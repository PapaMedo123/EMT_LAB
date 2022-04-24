package finki.emt.lab.service.Impl;

import finki.emt.lab.model.Author;
import finki.emt.lab.model.Book;
import finki.emt.lab.model.Country;
import finki.emt.lab.model.exeptions.CountryNotFound;
import finki.emt.lab.repository.CountryRepository;
import finki.emt.lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        return  Optional.of(countryRepository.save(new Country(name,continent)));
    }

    @Override
    public Optional<Country> update(Long id, String name, String continent) {
        Country country = countryRepository
                .findById(id).orElseThrow(() -> new CountryNotFound(id+""));

        country.setName(name);
        country.setContinent(continent);
        return  Optional.of(countryRepository.save(country));
    }
}
