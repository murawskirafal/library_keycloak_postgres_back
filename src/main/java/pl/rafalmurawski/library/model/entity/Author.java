package pl.rafalmurawski.library.model.entity;


import pl.rafalmurawski.library.model.AddAuthorCommand;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "lastName"}))
@SequenceGenerator(name = "myGenerator", initialValue = 5)
public class Author {

    @Id
    @GeneratedValue(generator = "myGenerator")
    private Long id;

    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String lastName;

    public Author() {
    }

    public Author(@NotEmpty @NotNull String name, @NotEmpty @NotNull String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Author(AddAuthorCommand addAuthorCommand) {
        this.name = addAuthorCommand.getName();
        this.lastName = addAuthorCommand.getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
