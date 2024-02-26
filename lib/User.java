package lib;
import java.util.UUID;

public class User {
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public UUID user_UUID;
    protected String uscID;
    public User(String userName, String password, String firstName, String lastName, String uscID) {
        this.username = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uscID = uscID;
    }
    public String getUserName() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
