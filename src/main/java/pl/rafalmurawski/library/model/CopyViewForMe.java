package pl.rafalmurawski.library.model;


import pl.rafalmurawski.library.model.entity.Author;
import pl.rafalmurawski.library.model.entity.Copy;

import java.util.List;

public class CopyViewForMe {
    private Long signature;
    private String isbn;
    private String bookTitle;
    private List<Author> authorList;


    public CopyViewForMe(CopyViewForMe copy) {
    }

    public CopyViewForMe(String isbn, String bookTitle, Long signature, List<Author> authorList) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.signature = signature;
        this.authorList = authorList;
    }

    public CopyViewForMe(Copy copy) {
        this.isbn = copy.getBook().getIsbn();
        this.bookTitle = copy.getBook().getTitle();
        this.signature = copy.getId();
        this.authorList = copy.getBook().getAuthorList();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Long getSignature() {
        return signature;
    }

    public void setSignature(Long signature) {
        this.signature = signature;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }


}

