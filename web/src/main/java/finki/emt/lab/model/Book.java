package finki.emt.lab.model;

import finki.emt.lab.model.enums.BookCategory;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @ManyToOne
    private Author author;

    private int availableCopies;

    public Book(String name, BookCategory category, Author author, int availableCopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book(){}
}
