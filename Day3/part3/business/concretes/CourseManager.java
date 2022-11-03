package hw3.part3.business.concretes;

import hw3.part3.business.abstracts.CourseService;
import hw3.part3.business.validators.CourseValidator;
import hw3.part3.core.logger.Logger;
import hw3.part3.entities.concretes.Course;

public class CourseManager implements CourseService {

    private Logger logger;

    public CourseManager(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void getAll() {
        logger.log("Courses listed.");
    }

    @Override
    public void add(Course course) {
        if (CourseValidator.isValid(course) && !this.checkIfCourseWithSameNameExists(course)) {
            logger.log(course.getName() + " added.");
        } else {
            logger.log("Validation error for course.");
        }
    }

    @Override
    public void update(Course course) {
        logger.log(course.getName() + " updated.");
    }

    @Override
    public void delete(Course course) {
        logger.log(course.getName() + " deleted.");
    }

    private boolean checkIfCourseWithSameNameExists(Course course) {
        // Use coursedao(getByName or etc.) to find if same named course exists.
        return false;
    }
}
