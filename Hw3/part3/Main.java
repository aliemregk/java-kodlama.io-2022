package hw3.part3;

import hw3.part3.business.concretes.CategoryManager;
import hw3.part3.business.concretes.CourseManager;
import hw3.part3.business.concretes.InstructorManager;
import hw3.part3.core.logger.HibernateLogger;
import hw3.part3.core.logger.JdbcLogger;
import hw3.part3.core.logger.Logger;
import hw3.part3.entities.concretes.Category;
import hw3.part3.entities.concretes.Course;
import hw3.part3.entities.concretes.Instructor;

public class Main {
    public static void main(String[] args) {

        Category category1 = new Category(1, "Category 1");
        Category category2 = new Category(2, "Category 2");

        Instructor instructor1 = new Instructor(1, "First", "Instructor", "instructor1@email");
        Instructor instructor2 = new Instructor(2, "Second", "Instructor", "instructor2@email");

        Course course1 = new Course(1, "Course 1", 500, instructor1, category1);
        Course course2 = new Course(2, "Course 2", 200, instructor2, category1);
        Course course3 = new Course(3, "Course 3", 300, instructor1, category2);

        Logger logger = new HibernateLogger();

        CategoryManager categoryManager = new CategoryManager(logger);
        categoryManager.add(category1);
        categoryManager.add(category2);
        categoryManager.update(category2);
        categoryManager.delete(category2);
        categoryManager.getAll();

        Category category3 = new Category(3, "");
        categoryManager.add(category3);

        System.out.println("-------------");

        InstructorManager instructorManager = new InstructorManager(logger);
        instructorManager.add(instructor1);
        instructorManager.add(instructor2);
        instructorManager.update(instructor2);
        instructorManager.delete(instructor2);
        instructorManager.getAll();
        System.out.println("-------------");

        logger = new JdbcLogger();

        CourseManager courseManager = new CourseManager(logger);
        courseManager.add(course1);
        courseManager.update(course2);
        courseManager.delete(course3);
        courseManager.getAll();

        Course course4 = new Course(4, "Course 4", 0, instructor2, category2);
        courseManager.add(course4);
        System.out.println("-------------");
    }
}
