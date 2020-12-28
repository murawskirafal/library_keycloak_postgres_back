package pl.rafalmurawski.library.model.entity;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class BorrowingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Claim(standard = Claims.email)
    String userEmail;

    @OneToOne
    @NotNull
    private Copy copy;

    @NotNull
    private LocalDate borrowingDate;

    private LocalDate dateOfReturn;

    public BorrowingHistory() {
    }


      public BorrowingHistory(@NotNull Copy copy) {
        this.copy = copy;
        this.borrowingDate = LocalDate.now();
        this.userEmail = copy.getUserEmail();
    }

    public Long getId() {
        return id;
    }

    public Copy getCopy() {
        return copy;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
