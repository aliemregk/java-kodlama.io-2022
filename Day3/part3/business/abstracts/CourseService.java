package hw3.part3.business.abstracts;

import hw3.part3.entities.concretes.Course;

public interface CourseService {

    void getAll();

    void add(Course course);

    void update(Course course);

    void delete(Course course);

}
