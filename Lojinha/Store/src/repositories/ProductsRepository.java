package repositories;
import entities.Category;
import entities.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepository {
    public static List<Product> products = new ArrayList<>();
    public static List<Category> categories = CategoriesRepository.getCategories();

    static {
        products.add(new Product("Notebook", 3500.00f, 10, categories.get(0).getId()));
        products.add(new Product("Mouse", 150.00f, 50, categories.get(0).getId()));
        products.add(new Product("Teclado", 200.00f, 30, categories.get(0).getId()));
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static Product findById(String id){
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static void decreaseProductStock(String id, int quantity) {
        Product product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (product != null) {
            product.decreaseStock(quantity);
        }
    }
}