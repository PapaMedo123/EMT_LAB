package finki.emt.lab.service.Impl;

import finki.emt.lab.model.Author;
import finki.emt.lab.model.Country;
import finki.emt.lab.model.exeptions.AuthorNotFound;
import finki.emt.lab.model.exeptions.CountryNotFound;
import finki.emt.lab.repository.AuthorRepository;
import finki.emt.lab.repository.CountryRepository;
import finki.emt.lab.service.AuthorService;
import finki.emt.lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> getById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = countryRepository
                .findById(countryId).orElseThrow(() -> new CountryNotFound  (countryId+""));

        return Optional.of(authorRepository.save(new Author(name,surname,country)));
    }

    @Override
    public Optional<Author> update(Long id, String name, String surname, Long countryId) {
        Author author = this.authorRepository
                .findById(id).orElseThrow(() -> new AuthorNotFound(id+""));

        Country country = countryRepository
                .findById(countryId).orElseThrow(() -> new CountryNotFound(countryId+""));

        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return Optional.of(authorRepository.save(author));
    }
}
