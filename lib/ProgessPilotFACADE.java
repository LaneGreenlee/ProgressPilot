package lib;

import java.util.ArrayList;

public class ProgessPilotFACADE {
    private User user;
    private Student student;
    private Advisor advisor;
    protected UserList userlist;
    protected MajorList majorList;
    protected CourseList courseList;

    public ProgessPilotFACADE () {
        userlist = new UserList();
        majorList = new MajorList();
        courseList = new CourseList();

    }
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
    public Student studentLogin(String userName, String password) {
        // Assuming UserList.getUser() method is intended to find a user by username
        this.student = UserList.getStudent(userName); // Adjusted to pass userName
        if (this.student != null && this.student.getPassword().equals(password)) {
            return this.student;
        } else {
            return null;
        }
    }
    public Advisor advisorLogin(String userName, String password) {
        // Assuming UserList.getUser() method is intended to find a user by username
        this.advisor = UserList.getAdvisor(userName); // Adjusted to pass userName
        if (this.advisor != null && this.advisor.getPassword().equals(password)) {
            return this.advisor;
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
        //return this.user != null;
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
    public boolean createAccount(String userName, String password, String firstName, String lastName, String uscID)
	{
        User newUser = new User(userName, password, firstName, lastName, uscID);
		UserList.addUser(newUser);
        return true;
	}

}
