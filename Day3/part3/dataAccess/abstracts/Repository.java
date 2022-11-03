package hw3.part3.dataAccess.abstracts;

import java.util.List;

// Example repository interface
public interface Repository<T> {

    List<T> getAll();

    void add(T entity);

    void update(T entity);

    void delete(T entity);
}
