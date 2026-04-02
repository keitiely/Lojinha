package repositories;

import entities.Category;

import java.util.Arrays;
import java.util.List;

public class CategoriesRepository {
    public static Category[] categories = {
            new Category( "Eletrônicos"),
    };

    public static List<Category> getCategories() {
        return Arrays.asList(categories);
    }
}