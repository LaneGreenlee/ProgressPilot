package lib;

import java.util.ArrayList;

public class ProgessPilotFACADE {
    private User user;

    // Login method
    public User login(String userName, String password) {
        // Assuming UserList.getUser() method is intended to find a user by username
        this.user = UserList.getUser(userName); // Adjusted to pass userName
        if (this.user != null && this.user.getPassword().equals(password)) {
            return this.user;
        } else {
            return null;
        }
    }

    // Logout method
    public void logout() {
        this.user = null;
    }

    // Check if a user is logged in
    public boolean isLoggedIn() {
        return this.user != null;
    }

    // Signup method
    public User signup(String userName, String password, String firstName, String lastName, String uscID) {
        // Check if user already exists
        if (UserList.getUser(userName) != null) {
            // User already exists
            return null;
        } else {
            // Create a new user and add it to the user list
            User newUser = new User(userName, password, firstName, lastName, uscID);
            UserList.addUser(newUser); // Assuming there's an addUser method in UserList
            return newUser;
        }
    }
    public ArrayList<Course> getAllCourses() {
      return null;
    }
    public ArrayList<Major> getAllMajors() {
      return null;
    }
    public ArrayList<Course> getCourseByMajor (Major major) {
      return null;
    }

}
