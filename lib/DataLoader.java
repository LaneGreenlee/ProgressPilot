package lib;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
     public ArrayList<Student> getAllStudents(String filePath) {
        ArrayList<Student> students = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray studentsArray = (JSONArray) jsonObject.get("students");

            for (Object studentObj : studentsArray) {
                JSONObject studentJson = (JSONObject) studentObj;

                String userName = (String) studentJson.get("userName");
                String password = (String) studentJson.get("password");
                String firstName = (String) studentJson.get("firstName");
                String lastName = (String) studentJson.get("lastName");
                String uscID = (String) studentJson.get("uscID");
                MajorName major = (MajorName) studentJson.get("major");
                Double gpa = (Double) studentJson.get("gpa");
                students.add(new Student(userName, password, firstName, lastName, uscID, uscID, major, gpa));
            }
        } catch (IOException | ParseException e) {
            ((Throwable) e).printStackTrace();
            // Handle exceptions
        }

        return students;
    }
    public ArrayList<Advisor> getAllAdvisors(String filePath) {
        ArrayList<Advisor> advisors = new ArrayList<>();

        // First, get all students to pass to Advisor constructor
        ArrayList<Student> allStudents = getAllStudents(filePath);

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray advisorsArray = (JSONArray) jsonObject.get("advisors");

            for (Object advisorObj : advisorsArray) {
                JSONObject advisorJson = (JSONObject) advisorObj;

                String userName = (String) advisorJson.get("userName");
                String password = (String) advisorJson.get("password");
                String firstName = (String) advisorJson.get("firstName");
                String lastName = (String) advisorJson.get("lastName");
                String uscID = (String) advisorJson.get("uscID");

                // Create Advisor object passing the list of students
                advisors.add(new Advisor(allStudents, userName, password, firstName, lastName, uscID));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            // Handle exceptions
        }

        return advisors;
    }
}
