package pl.rafalmurawski.library.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String userEmail;


    @ManyToOne
    @NotNull
    private Book book;

    public Copy() {
    }


    public Copy(@NotNull Book book) {
        this.book = book;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
