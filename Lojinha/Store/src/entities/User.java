package entities;
import java.util.UUID;

public class User {
    private String id;
    private String email;
    private String password;
    private String name;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
