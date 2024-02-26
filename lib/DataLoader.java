package lib;

import java.util.ArrayList;

public class DataLoader {
    
    public ArrayList<Course> getCourses() {
        return new ArrayList<Course>();
    }
    public ArrayList<User> getUsers() {
        return new ArrayList<User>();
    }
    public ArrayList<Major> getMajors() {
        return new ArrayList<Major>();
    }
    public ArrayList<Student> getAllStudents(Advisor advisor) {
        ArrayList<Student> allStudents = new ArrayList<>();
        if (advisor != null) {
            ArrayList<Student> advisorStudents = advisor.viewStudents();
            if (advisorStudents != null) {
                allStudents.addAll(advisorStudents);
            }
        }
        return allStudents;
    }
    public ArrayList<Advisor> getAllAdvisors() {
        return null;
    }
}
