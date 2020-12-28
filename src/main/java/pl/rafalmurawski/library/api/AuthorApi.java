package pl.rafalmurawski.library.api;

import pl.rafalmurawski.library.model.AddAuthorCommand;
import pl.rafalmurawski.library.model.entity.Author;
import pl.rafalmurawski.library.service.AuthorService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorApi {


    private final AuthorService authorService;


    @Inject
    public AuthorApi(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GET
    @RolesAllowed({"user", "admin"})
    public List<Author> getAuthorList() {
        return authorService.showAllAuthors();
    }

    @POST
    @RolesAllowed({"user", "admin"})
    public Author addAuthor(AddAuthorCommand addAuthorCommand) {
        return authorService.addAuthor(addAuthorCommand);
    }
}
