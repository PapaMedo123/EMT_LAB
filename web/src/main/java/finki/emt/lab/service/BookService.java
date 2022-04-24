package finki.emt.lab.service;

import finki.emt.lab.model.Author;
import finki.emt.lab.model.Book;
import finki.emt.lab.model.Dto.BookDto;
import finki.emt.lab.model.enums.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> getById(Long id);

    void delete(Long id);

    Optional<Book> save(String name, BookCategory category, Long author, int availableCopies);

    Optional<Book> update(Long id, String name, BookCategory category, Long author, int availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> update(Long id, BookDto bookDto);

    Optional<Book> mark(Long id);
}
