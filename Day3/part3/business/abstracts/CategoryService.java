package hw3.part3.business.abstracts;

import hw3.part3.entities.concretes.Category;

public interface CategoryService {

    void getAll();

    void add(Category category);

    void update(Category category);

    void delete(Category category);

}
