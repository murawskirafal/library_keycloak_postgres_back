package pl.rafalmurawski.library.service;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import pl.rafalmurawski.library.model.AddCopyCommand;
import pl.rafalmurawski.library.model.CopyViewForAll;
import pl.rafalmurawski.library.model.CopyViewForMe;
import pl.rafalmurawski.library.model.entity.Book;
import pl.rafalmurawski.library.model.entity.BorrowingHistory;
import pl.rafalmurawski.library.model.entity.Copy;
import pl.rafalmurawski.library.model.repository.BookRepository;
import pl.rafalmurawski.library.model.repository.BorrowingHistoryRepository;
import pl.rafalmurawski.library.model.repository.CopyRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
public class CopyService {

    private final CopyRepository copyRepository;
    private final BookRepository bookRepository;
    private final BorrowingHistoryRepository borrowingHistoryRepository;


    @Inject
    public CopyService(CopyRepository copyRepository, BookRepository bookRepository, BorrowingHistoryRepository borrowingHistoryRepository) {
        this.copyRepository = copyRepository;
        this.bookRepository = bookRepository;
        this.borrowingHistoryRepository = borrowingHistoryRepository;
    }


    @Transactional
    public void addCopy(AddCopyCommand addCopyCommand) {
        bookRepository.find("isbn", addCopyCommand.getIsbn()).firstResultOptional()
                .ifPresent(book -> addCopies(addCopyCommand.getQuantity(), book));
    }

    private void addCopies(int quantity, Book book) {
        IntStream.range(0, quantity)
                .forEach(notUsed ->
                        copyRepository.persist(new Copy(book)));
    }

    private Copy rentBook(Copy copy, String userEmaill) {
        copy.setUserEmail(userEmaill);
        borrowingHistoryRepository.persist(new BorrowingHistory(copy));
        copyRepository.persist(copy);
        return copy;
    }


    public List<CopyViewForAll> showAllCopies() {

        Map<Book, List<Copy>> copies = copyRepository.findAll().stream()
                .collect(Collectors.groupingBy(Copy::getBook));

        return copies.entrySet().stream()
                .map(entry -> new CopyViewForAll(entry.getKey().getIsbn(),
                        entry.getKey().getTitle(),
                        entry.getValue().size(),
                        (int) entry.getValue().stream().filter(copy -> copy.getUserEmail() == null).count()))
                .collect(toList());
    }

    public List<BorrowingHistory> getBorrowingHistoryList() {
        return borrowingHistoryRepository.findAll().list();
    }


    @Transactional
    public void returnCopy(Long signature, String userEmail) {

        copyRepository.findByIdOptional(signature)
                .map(copy -> {
                    borrowingHistoryRepository.find("useremail = ?1 and copy_id = ?2", userEmail, copy.getId()).firstResultOptional()
                            .map(history -> {
                                history.setDateOfReturn(LocalDate.now());
                                borrowingHistoryRepository.persist(history);
                                return history;
                            }).orElseThrow(() -> new RuntimeException("History not found"));

                    copy.setUserEmail(null);
                    copyRepository.persist(copy);
                    return copy;
                }).orElseThrow(() -> new RuntimeException("Copy not found"));
    }

    @Transactional
    public void rentCopy(String userEmaill,String isbn) {

        System.out.println(userEmaill);
        System.out.println(">>>>>>>>> SERWIS " + this);

        bookRepository.find("isbn", isbn).firstResultOptional()
                .map(book -> copyRepository.find("book", book))
                .flatMap(copies -> copies.stream()
                        .filter(copy -> copy.getUserEmail() == null)
                        .findFirst())
                .map(copy -> rentBook(copy, userEmaill))
                .orElseThrow(() -> new RuntimeException("no books to rent"));
    }

    public List<CopyViewForMe> showMyCopies(String userEmail) {
        return copyRepository.find("userEmail", userEmail).stream().map(copy -> new CopyViewForMe(copy)).collect(toList());
    }
}
