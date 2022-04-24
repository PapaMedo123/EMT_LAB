package finki.emt.lab.service;

import finki.emt.lab.model.Author;
import finki.emt.lab.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> getById(Long id);

    void delete(Long id);

    Optional<Author> save(String name, String surname, Long country);

    Optional<Author> update(Long id, String name, String surname, Long country);
}
