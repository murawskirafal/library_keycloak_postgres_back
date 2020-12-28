package pl.rafalmurawski.library.model.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import pl.rafalmurawski.library.model.entity.BorrowingHistory;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BorrowingHistoryRepository implements PanacheRepository<BorrowingHistory> {

//    Optional<BorrowingHistory> findByUserAndCopy(User loggedUser, Copy copy);

}
