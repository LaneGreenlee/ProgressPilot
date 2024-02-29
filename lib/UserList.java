package lib;

import java.util.ArrayList;

public class UserList {
    private static UserList instance;
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;
    public UserList() {
        students = new ArrayList<>();
        advisors = new ArrayList<>();
    }
    public static  User getUser(String userName) {
        return null;
    }

    public static  void addUser(User newUser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addUser'");
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
