package lib;
import java.util.UUID;

public class User {
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public UUID user_UUID;
    protected String uscID;
    // constructor called when user is loaded from json ( has UUID )
    public User(String userName, String password, String firstName, String lastName, String uscID, UUID user_UUID) {
        this.username = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uscID = uscID;
        this.user_UUID = user_UUID;
    }
    // constructor called when user is loaded from json ( has UUID )
    public User(String userName, String password, String firstName, String lastName, String uscID) {
        this.username = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uscID = uscID;
        this.user_UUID = UUID.randomUUID();
    }
    public String getUserName() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUSCID() {
        return uscID;
    }
    public UUID getID() {
        return user_UUID;
    }
}
