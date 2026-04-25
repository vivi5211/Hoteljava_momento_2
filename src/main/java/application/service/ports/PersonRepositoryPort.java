package application.service.ports;

import application.domain.Person;
import java.util.List;
import java.util.Optional;

public interface PersonRepositoryPort<T extends Person> {
    T save(T person);
    T update(int id, T person);
    Optional<T> findById(int id);
    List<T> findAll();
    void deleteById(int id);
}