package pl.rafalmurawski.library.model.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import pl.rafalmurawski.library.model.entity.Copy;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CopyRepository implements PanacheRepository<Copy> {

//    List<Copy> findAllByBook(Book book);
//
//    Optional<Copy> findAllById(Long id);
//
//    List<Copy> findAllByUser(User user);

}
