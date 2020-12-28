package pl.rafalmurawski.library.model;



import pl.rafalmurawski.library.model.entity.BorrowingHistory;

import java.time.LocalDate;

public class BorrowingHistoryView {

    private String userEmail;

    private LocalDate borrowingDate;

    private LocalDate dateOfReturn;

    private String bookIsbn;

    private String bookTitle;

    private Long copySignature;

    public BorrowingHistoryView() {
    }

    public BorrowingHistoryView(String userEmail, LocalDate borrowingDate, LocalDate dateOfReturn, String bookIsbn, String bookTitle, Long copySignature) {
        this.userEmail = userEmail;
        this.borrowingDate = borrowingDate;
        this.dateOfReturn = dateOfReturn;
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.copySignature = copySignature;
    }

    public BorrowingHistoryView(BorrowingHistory history) {
        this.userEmail = history.getUserEmail();
        this.borrowingDate = history.getBorrowingDate();
        this.dateOfReturn = history.getDateOfReturn();
        this.bookIsbn = history.getCopy().getBook().getIsbn();
        this.bookTitle = history.getCopy().getBook().getTitle();
        this.copySignature = history.getCopy().getId();

    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Long getCopySignature() {
        return copySignature;
    }

    public void setCopySignature(Long copySignature) {
        this.copySignature = copySignature;
    }
}
