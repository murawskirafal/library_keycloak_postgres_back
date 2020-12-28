package pl.rafalmurawski.library.service;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import pl.rafalmurawski.library.model.BorrowingHistoryView;
import pl.rafalmurawski.library.model.repository.BorrowingHistoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BorrowingHistoryService {

    private BorrowingHistoryRepository borrowingHistoryRepository;


    @Inject
    public BorrowingHistoryService(BorrowingHistoryRepository borrowingHistoryRepository) {
        this.borrowingHistoryRepository = borrowingHistoryRepository;
    }

    public List<BorrowingHistoryView> getBorrowingHistoryList() {
        return borrowingHistoryRepository.findAll().stream().map(history -> new BorrowingHistoryView(history)).collect(Collectors.toList());

    }

    public List<BorrowingHistoryView> getMyBorrowingHistoryList(String userEmail) {
        return borrowingHistoryRepository.find("useremail", userEmail).stream().map(history -> new BorrowingHistoryView(history)).collect(Collectors.toList());
    }
}
