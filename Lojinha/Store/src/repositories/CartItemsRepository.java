package repositories;
import entities.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartItemsRepository {
    public static List<CartItem> cartItemList = new ArrayList<>();

    public static CartItem createCartItem(String cartId, String productId, int quantity) {
        CartItem cartItem = new CartItem(cartId, productId, quantity);
        cartItemList.add(cartItem);
        return cartItem;
    }

    public static CartItem findByProductId(String productId){
        return cartItemList.stream()
                .filter(c -> c.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }
}
