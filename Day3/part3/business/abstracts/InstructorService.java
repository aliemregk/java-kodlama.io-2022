package hw3.part3.business.abstracts;

import hw3.part3.entities.concretes.Instructor;

public interface InstructorService {

    void getAll();

    void add(Instructor instructor);

    void update(Instructor instructor);

    void delete(Instructor instructor);

}
