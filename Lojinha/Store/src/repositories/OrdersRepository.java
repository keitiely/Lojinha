package repositories;

import entities.Order;
import types.OrderStatus;

public class OrdersRepository {
    public static Order createOrder() {
        return new Order(OrderStatus.PENDING);
    }
}
