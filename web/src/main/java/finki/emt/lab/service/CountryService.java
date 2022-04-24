package finki.emt.lab.service;

import finki.emt.lab.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> getById(Long id);

    void delete(Long id);

    Optional<Country> save(String name, String continent);

    Optional<Country> update(Long id, String name, String continent);
}
