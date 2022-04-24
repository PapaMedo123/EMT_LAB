package finki.emt.lab.service.Impl;

import finki.emt.lab.model.Author;
import finki.emt.lab.model.Book;
import finki.emt.lab.model.Dto.BookDto;
import finki.emt.lab.model.enums.BookCategory;
import finki.emt.lab.model.exeptions.AuthorNotFound;
import finki.emt.lab.model.exeptions.BookNotFound;
import finki.emt.lab.repository.AuthorRepository;
import finki.emt.lab.repository.BookRepository;
import finki.emt.lab.service.AuthorService;
import finki.emt.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> save(String name, BookCategory category, Long authorId, int availableCopies) {
        Author author = this.authorRepository
                .findById(authorId).orElseThrow(() -> new AuthorNotFound(authorId + ""));

        return Optional.of(bookRepository.save(new Book(name, category, author, availableCopies)));
    }

    @Override
    public Optional<Book> update(Long id, String name, BookCategory category, Long authorId, int availableCopies) {
        Book book = bookRepository
                .findById(id).orElseThrow(() -> new BookNotFound(id + ""));

        Author author = this.authorRepository
                .findById(authorId).orElseThrow(() -> new AuthorNotFound(authorId + ""));

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Long authorId = bookDto.getAuthor();
        Author author = this.authorRepository
                .findById(authorId).orElseThrow(() -> new AuthorNotFound(authorId + ""));

        return Optional.of(bookRepository
                .save(new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book = bookRepository
                .findById(id).orElseThrow(() -> new BookNotFound(id + ""));

        Long authorId = bookDto.getAuthor();
        Author author = this.authorRepository
                .findById(authorId).orElseThrow(() -> new AuthorNotFound(authorId + ""));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(bookRepository
                .save(book));
    }

    @Override
    public Optional<Book> mark(Long id) {
        Book book = bookRepository
                .findById(id).orElseThrow(() -> new BookNotFound(id + ""));

        int avaiable = book.getAvailableCopies();
        if(avaiable > 0) {
            avaiable--;
            book.setAvailableCopies(avaiable);
        }
        return Optional.of(bookRepository
                .save(book));
    }
}
