package entities;
import java.util.UUID;

public class CartItem {
    private String id;
    private String cartId;
    private String productId;
    private int quantity;

    public CartItem(String cartId, String productId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getCartId() {
        return cartId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

