package lib;

import java.util.ArrayList;

public class UserList {
    private static UserList instance;
    private static ArrayList<User> user;
    public static ArrayList<Student> students;
    private static ArrayList<Advisor> advisors;
    public UserList() {
        students = new ArrayList<>();
        advisors = new ArrayList<>();
    }
    public static  User getUser(String userName) {
        for (int i =0; i< user.size(); i++) {
            if (user.get(i).username.equals(userName))
            return user.get(i);
    }
        return null;
    }
    public static  Student getStudent(String userName) {
        for (int i =0; i < students.size(); i++) {
            if (students.get(i).username.equals(userName))
            return students.get(i);
    }
        return null;
    }
    public static  Advisor getAdvisor(String userName) {
        for (int i =0; i < advisors.size(); i++) {
            if (advisors.get(i).username.equals(userName))
            return advisors.get(i);
    }
        return null;
    }

    public static  void addUser(User newUser) {
        user.add(newUser);
    }
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to add an advisor
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
