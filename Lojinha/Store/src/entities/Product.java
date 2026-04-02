package entities;
import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private Float price;
    private int stock;
    private String categoryId;

    public Product(String name, Float price, int stock, String categoryId) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.id = UUID.randomUUID().toString();
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoryId(){
        return categoryId;
    }

    public void decreaseStock(int quantity){
        stock-= quantity;
    }
}
