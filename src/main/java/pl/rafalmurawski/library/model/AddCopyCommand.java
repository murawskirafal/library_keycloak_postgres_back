package pl.rafalmurawski.library.model;

public class AddCopyCommand {

    private String isbn;
    private Integer quantity;

    public AddCopyCommand() {
    }

    public AddCopyCommand(String isbn, Integer quantity) {
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
