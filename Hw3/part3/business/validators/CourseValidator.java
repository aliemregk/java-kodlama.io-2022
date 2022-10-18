package hw3.part3.business.validators;

import hw3.part3.entities.concretes.Course;

public class CourseValidator {

    public static boolean isValid(Course course) {
        if (!course.getName().isEmpty() && course.getPrice() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
