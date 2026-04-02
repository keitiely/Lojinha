package entities;
import java.util.UUID;

public class Cart {
    private String id;
    private String userId;

    public Cart(String userId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }
}
