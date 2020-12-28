package pl.rafalmurawski.library.model;

public class AddAuthorCommand {
    String name;
    String lastName;

    public AddAuthorCommand() {
    }

    public AddAuthorCommand(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
