package hr.croz.unicorn.service;


import java.util.List;
import java.util.Optional;

public interface CRUDService<T, U> {

        Optional<T> getById(U id);

        List<T> getAll();

        T save(T entity);

        T update(T entity);

        void delete(T entity);

        void deleteById(U id);

}
