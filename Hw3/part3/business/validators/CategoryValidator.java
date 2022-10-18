package hw3.part3.business.validators;

import hw3.part3.entities.concretes.Category;

public class CategoryValidator {

    public static boolean isValid(Category category) {
        if (category.getName().isEmpty() || category.getName().isBlank()) {
            return false;
        } else {
            return true;
        }
    }
}
