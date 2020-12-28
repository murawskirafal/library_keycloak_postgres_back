package pl.rafalmurawski.library.model.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import pl.rafalmurawski.library.model.entity.Author;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository implements PanacheRepository<Author> {


//    Optional<Author> findByNameAndLastName(String name, String lastName);


}
