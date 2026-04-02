package entities;
import types.OrderStatus;
import java.util.UUID;


public class Order {
    private String id;
    private OrderStatus status;

    public Order(OrderStatus status) {
        this.status = status;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
