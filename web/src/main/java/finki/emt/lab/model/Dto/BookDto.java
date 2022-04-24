package finki.emt.lab.model.Dto;

import finki.emt.lab.model.Author;
import finki.emt.lab.model.enums.BookCategory;
import lombok.Data;

import javax.persistence.*;

@Data
public class BookDto {

    private Long id;

    private String name;

    private BookCategory category;

    private Long author;

    private int availableCopies;

    public BookDto(String name, BookCategory category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

}
