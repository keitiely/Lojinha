package entities;

import java.util.UUID;

public class OrderItem {
    private String id;
    private String orderId;
    private String productId;
    private Float priceAtPurchase;

    public OrderItem(String orderId, String productId, Float priceAtPurchase) {
        this.orderId = orderId;
        this.productId = productId;
        this.priceAtPurchase = priceAtPurchase;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public Float getPriceAtPurchase() {
        return priceAtPurchase;
    }
}
