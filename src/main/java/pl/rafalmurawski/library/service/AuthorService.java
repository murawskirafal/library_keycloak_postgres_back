package pl.rafalmurawski.library.service;

import pl.rafalmurawski.library.model.AddAuthorCommand;
import pl.rafalmurawski.library.model.entity.Author;
import pl.rafalmurawski.library.model.repository.AuthorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Inject
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public List<Author> showAllAuthors() {
        return authorRepository.findAll().list();
    }

    @Transactional
    public Author addAuthor(AddAuthorCommand addAuthorCommand) {
        return findAuthorByAuthorCommand(addAuthorCommand)
                .orElseGet(() -> {
                    Author author = new Author(addAuthorCommand.getName().toUpperCase(), addAuthorCommand.getLastName().toUpperCase());
                    authorRepository.persist(author);
                    return author;
                });
    }


    public Optional<Author> findAuthorByAuthorCommand(AddAuthorCommand addAuthorCommand) {

        return authorRepository.find("name = ?1 and lastname = ?2", addAuthorCommand.getName().toUpperCase(), addAuthorCommand.getLastName().toUpperCase()).firstResultOptional();
    }

}
