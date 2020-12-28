package pl.rafalmurawski.library.model.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import pl.rafalmurawski.library.model.entity.Book;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {

}
