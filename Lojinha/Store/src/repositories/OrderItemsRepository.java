package repositories;
import entities.OrderItem;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsRepository {
    public static List<OrderItem> orderItems = new ArrayList<>();

    public static void createOrderItem(String orderId, String productId, float priceAtPurchase) {
         orderItems.add(new OrderItem(orderId, productId, priceAtPurchase));
    }
}
