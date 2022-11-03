package hw3.part3.business.concretes;

import hw3.part3.business.abstracts.InstructorService;
import hw3.part3.core.logger.Logger;
import hw3.part3.entities.concretes.Instructor;

public class InstructorManager implements InstructorService {

    private Logger logger;

    public InstructorManager(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void getAll() {
        logger.log("Instructors listed.");
    }

    @Override
    public void add(Instructor instructor) {
        logger.log(instructor.getEmail() + " added.");
    }

    @Override
    public void update(Instructor instructor) {
        logger.log(instructor.getEmail() + " updated.");
    }

    @Override
    public void delete(Instructor instructor) {
        logger.log(instructor.getEmail() + " deleted.");
    }

}
