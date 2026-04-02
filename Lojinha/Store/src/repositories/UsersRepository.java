package repositories;
import entities.User;

public class UsersRepository {
    public static User user = new User("johndoe@gmail.com", "John Doe", "123456");
    public static User login(String email, String password) {
        if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
