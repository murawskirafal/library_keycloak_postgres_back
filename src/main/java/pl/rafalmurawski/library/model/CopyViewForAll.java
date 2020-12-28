package pl.rafalmurawski.library.model;

public class CopyViewForAll {
    private String isbn;
    private String bookTitle;
    private int allCopies;
    private int availableCopies;

    public CopyViewForAll() {
    }

    public CopyViewForAll(String isbn, String bookTitle, int allCopies, int availableCopies) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.allCopies = allCopies;
        this.availableCopies = availableCopies;
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

    public int getAllCopies() {
        return allCopies;
    }

    public void setAllCopies(int allCopies) {
        this.allCopies = allCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
