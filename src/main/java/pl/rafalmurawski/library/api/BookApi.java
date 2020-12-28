package pl.rafalmurawski.library.api;

import pl.rafalmurawski.library.model.AddBookCommand;
import pl.rafalmurawski.library.model.entity.Book;
import pl.rafalmurawski.library.service.BookService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookApi {

    private final BookService bookService;

    @Inject
    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @RolesAllowed({"user", "admin"})
    public List<Book> getBookList() {
        return bookService.showAllBooks();
    }

    @POST
    @RolesAllowed("admin")
    public void addBook(AddBookCommand addBookCommand) {
        bookService.addBook(addBookCommand);
    }

}
