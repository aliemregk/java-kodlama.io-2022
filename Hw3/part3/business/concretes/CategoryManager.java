package hw3.part3.business.concretes;

import hw3.part3.business.abstracts.CategoryService;
import hw3.part3.business.validators.CategoryValidator;
import hw3.part3.core.logger.Logger;
import hw3.part3.entities.concretes.Category;

public class CategoryManager implements CategoryService {

    private Logger logger;

    public CategoryManager(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void getAll() {
        logger.log("Categories listed.");
    }

    @Override
    public void add(Category category) {
        // Using a business engine would be better but if-else is enough for now.
        if (CategoryValidator.isValid(category) && !this.checkIfCategoryWithSameNameExists(category)) {
            logger.log(category.getName() + " added.");
        } else {
            logger.log("Validation error for category.");
        }
    }

    @Override
    public void update(Category category) {
        logger.log(category.getName() + " updated.");
    }

    @Override
    public void delete(Category category) {
        logger.log(category.getName() + " deleted.");
    }

    private boolean checkIfCategoryWithSameNameExists(Category category) {
        // Use categorydao(getByName or etc.) to find if same named category exists.
        return false;
    }
}
