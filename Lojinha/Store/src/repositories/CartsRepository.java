package repositories;
import entities.Cart;

public class CartsRepository {

    public static Cart createCart(String userId){
        return new Cart(userId);
    }
}
