package pl.rafalmurawski.library.model.entity;


import org.hibernate.validator.constraints.ISBN;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @ISBN
    private String isbn;

    @NotNull
    @NotEmpty
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authorList = new ArrayList<>();

    public Book() {
    }

    public Book(@ISBN String isbn, @NotNull @NotEmpty String title, List<Author> authorList) {
        this.isbn = isbn;
        this.title = title;
        this.authorList = authorList;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
