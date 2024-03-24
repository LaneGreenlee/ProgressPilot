package lib;

public class ProgessPilotFACADE {
    private User user;
    private Student student;
    private Advisor advisor;
    protected UserList userlist;
    protected MajorList majorList;
    protected CourseList courseList;
    /**
     * Creates a new userlist, majorlist and courselist
     */
    public ProgessPilotFACADE () {
        userlist = new UserList();
        majorList = new MajorList();
        courseList = CourseList.getInstance();
    }
    // Login method
    /**
     * takes in the input from the user in the driver then checks and see if it matches anything in the array list
     * @param userName username typed in by user
     * @param password password typed in by user
     * @return a user if the username and password matches someone on the list
     */
    public User login(String userName, String password) {
        // Assuming UserList.getUser() method is intended to find a user by username
        this.user = UserList.getUser(userName); // Adjusted to pass userName
        if (this.user != null && this.user.getPassword().equals(password)) {
            return this.user;
        } else {
            return null;
        }
    }
    /**
     * takes in the input from the user in the driver then checks and see if it matches anything in the student array list
     * @param userName username typed in by user
     * @param password password typed in by user
     * @return a student if the username and password matches someone on the list
     */
    public Student studentLogin(String userName, String password) {
        // Assuming UserList.getUser() method is intended to find a user by username
        this.student = UserList.getStudent(userName); // Adjusted to pass userName
        if (this.student != null && this.student.getPassword().equals(password)) {
            return this.student;
        } else {
            return null;
        }
    }
        /**
     * takes in the input from the user in the driver then checks and see if it matches anything in the advisor array list
     * @param userName username typed in by user
     * @param password password typed in by user
     * @return a advisor if the username and password matches someone on the list
     */
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
    /**
     * Sets user equal to null to logout the user
     */
    public void logout() {
        this.user = null;
    }

    // Check if a user is logged in
    /**
     * checks if user is not null
     * @return if user is not null return true, else return false
     */
    public boolean isLoggedIn() {
        return this.user != null;
        //return this.user != null;
    }

    // Signup method
    /**
     * takes in params from the user and creates a new user
     * @param userName username of new user
     * @param password password of new user
     * @param firstName first name of new user
     * @param lastName last name of new user
     * @param uscID usc ID of new user
     * @return the new user after creating with the params
     */
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
    /**
     * Creates a new user and then adds to the list using the passed in params
     * @param userName username of new user
     * @param password password of new user
     * @param firstName first name of new user
     * @param lastName last name of new user
     * @param uscID usc ID of new user
     * @return true when user is created
     */
    public boolean createAccount(String userName, String password, String firstName, String lastName, String uscID)
	{
        User newUser = new User(userName, password, firstName, lastName, uscID);
		UserList.addUser(newUser);
        return true;
	}

}
