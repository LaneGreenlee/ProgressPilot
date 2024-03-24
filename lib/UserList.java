package lib;

import java.util.ArrayList;

public class UserList {
    private static UserList instance;
    private static ArrayList<User> user;
    public static ArrayList<Student> students;
    public static ArrayList<Advisor> advisors;
    /**
     * constructor that initializes the studentss and advisor
     */
    public UserList() {
        students = new ArrayList<>();
        advisors = new ArrayList<>();
        user = new ArrayList<>();
    }
    /**
     * looks through the user array list until finds a user that matches the username
     * @param userName username that is being searched for
     * @return the user that matches the username
     */
    public static  User getUser(String userName) {
        for (int i =0; i< user.size(); i++) {
            if (user.get(i).getUserName().equals(userName))
            return user.get(i);
    }
        return null;
    }
        /**
     * looks through the student array list until finds a student that matches the username
     * @param userName username that is being searched for
     * @return the student that matches the username
     */
    public static  Student getStudent(String userName) {
        for (int i =0; i < students.size(); i++) {
               if (students.get(i).getUserName().equals(userName))
                return students.get(i);
    }
        return null;
    }
    public static  Student getStudentUSCID(String uscID) {
        for (int i =0; i < students.size(); i++) {
               if (students.get(i).getId().equals(uscID))
                return students.get(i);
    }
        return null;
    }
        /**
     * looks through the advisor array list until finds a advisor that matches the username
     * @param userName username that is being searched for
     * @return the advisor that matches the username
     */
    public static  Advisor getAdvisor(String userName) {
        for (int i =0; i < advisors.size(); i++) {
            if (advisors.get(i).getUserName().equals(userName))
            return advisors.get(i);
    }
        return null;
    }
    /**
     * takes in a user and adds them to the array list
     * @param newUser user that is being added to the list
     */
    public static  void addUser(User newUser) {
        user.add(newUser);
    }
    /**
     * takes in a student and adds them to the array list
     * @param student student that is being added to the list
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to add an advisor
    /**
     * takes in a advisor and adds them to the array list
     * @param advisor advisor that is being added to the list
     */
    public void addAdvisor(Advisor advisor) {
        advisors.add(advisor);
    }

    // Method to retrieve all students
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    // Method to retrieve all advisors
    public ArrayList<Advisor> getAllAdvisors() {
        return advisors;
    }
    
    public static UserList getInstance() {
        if (instance == null)
        {
        return (instance = new UserList());
        }
        else return instance;
    }
    public ArrayList<User> getAllUsers() {
        ArrayList<User> Users = new ArrayList<User>();
        for (int i =0; i< this.students.size(); i++)
        {
            Users.add(this.students.get(i));
        }
        for (int i =0; i< this.advisors.size(); i++)
        {
            Users.add(this.advisors.get(i));
        }
        return Users;
        
    }
}
