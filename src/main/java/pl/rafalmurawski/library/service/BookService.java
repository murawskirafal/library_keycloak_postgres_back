package pl.rafalmurawski.library.service;

import pl.rafalmurawski.library.model.AddBookCommand;
import pl.rafalmurawski.library.model.entity.Author;
import pl.rafalmurawski.library.model.entity.Book;
import pl.rafalmurawski.library.model.repository.BookRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Inject
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }


    public List<Book> showAllBooks() {
        return bookRepository.findAll().list();
    }

    @Transactional
    public void addBook(AddBookCommand addBookCommand) {
        List<Author> authors = addBookCommand.getAuthorList().stream()
                .map(authorService::addAuthor)
                .collect(Collectors.toList());

        bookRepository.persist(new Book(addBookCommand.getIsbn(), addBookCommand.getTitle().toUpperCase(), authors));

    }


}