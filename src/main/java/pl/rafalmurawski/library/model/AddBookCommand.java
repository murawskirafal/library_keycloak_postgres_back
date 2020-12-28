package pl.rafalmurawski.library.model;

import java.util.List;

public class AddBookCommand {

    private String title;
    private String isbn;
    private List<AddAuthorCommand> authorList;

    public AddBookCommand() {
    }

    public AddBookCommand(String title, String isbn, List<AddAuthorCommand> authorList) {
        this.title = title;
        this.isbn = isbn;
        this.authorList = authorList;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthorList(List<AddAuthorCommand> authorList) {
        this.authorList = authorList;
    }

    public List<AddAuthorCommand> getAuthorList() {
        return authorList;
    }
}
