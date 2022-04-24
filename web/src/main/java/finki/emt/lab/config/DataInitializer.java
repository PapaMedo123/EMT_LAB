package finki.emt.lab.config;

import finki.emt.lab.model.Author;
import finki.emt.lab.model.Book;
import finki.emt.lab.model.Country;
import finki.emt.lab.model.enums.BookCategory;
import finki.emt.lab.service.AuthorService;
import finki.emt.lab.service.BookService;
import finki.emt.lab.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
    public class DataInitializer {

        private final BookService bookService;

        private final AuthorService authorService;

        private final CountryService countryService;

        public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
            this.bookService = bookService;
            this.authorService = authorService;
            this.countryService = countryService;
        }

        private BookCategory randomizeCategory(int i) {
            if (i % 6 == 0) return BookCategory.NOVEL;
            else if (i % 6 == 1) return BookCategory.THRILER;
            else if (i % 6 == 2) return BookCategory.HISTORY;
            else if (i % 6 == 3) return BookCategory.FANTASY;
            else if (i % 6 == 4) return BookCategory.BIOGRAPHY;
            else if (i % 6 == 5) return BookCategory.CLASSICS;
            return BookCategory.DRAMA;
        }

        @PostConstruct
        public void initData() {
            this.countryService.save("contry" + 0, "mountains" + 0);
            for (int i = 1; i < 6; i++) {
                this.countryService.save("contry" + i, "mountains" + i);
            }

            List<Country> countries = this.countryService.findAll();
            this.authorService.save("author" + 0, "author_surname" + 0, countries.get(0).getId());
            for (int i = 1; i < 6; i++) {
                this.authorService.save("author" + i, "author_surname" + 0, countries.get(i).getId());
            }

            List<Author> authors = this.authorService.findAll();
            for (int i = 1; i < 11; i++) {
                this.bookService.save(
                        "book: " + i,
                        this.randomizeCategory(i),
                        authors.get(i % 5).getId(),
                        i
                );
            }
        }
    }

