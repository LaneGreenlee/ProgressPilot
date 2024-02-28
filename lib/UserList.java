package lib;

import java.util.ArrayList;

public class UserList {
    private static UserList instance;
    private static ArrayList<User> user;
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;
    public UserList() {
        user = new ArrayList<User>();
        students = new ArrayList<>();
        advisors = new ArrayList<>();
    }
    public static  User getUser(String userName) {
     System.out.println(user.get(0));
      for (int i =0; i< user.size(); i++) {
        if (user.get(i).username.equals(userName))
        return user.get(i);
      }
      return null;
    }

    public static  void addUser(User newUser) {
        
        user.add(newUser);
        //throw new UnsupportedOperationException("Unimplemented method 'addUser'");
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
    

    
}
