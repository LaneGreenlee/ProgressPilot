package lib;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

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
        //ArrayList<Student> students = new ArrayList<>();

        try {
            FileReader reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            //JSONObject jsonObject = (JSONObject) obj;

            JSONArray studentsArray = (JSONArray) new JSONParser().parse(reader);

            for (Object studentObj : studentsArray) {
                JSONObject studentJson = (JSONObject) studentObj;

                String userName = (String) studentJson.get("username");
                String password = (String) studentJson.get("password");
                String firstName = (String) studentJson.get("firstName");
                String lastName = (String) studentJson.get("lastName");
                String uscID = (String) studentJson.get("uscID");
                UUID user_UUID = UUID.fromString((String)studentJson.get("user_UUID"));
                String gradYear = (String) studentJson.get("gradYear");
                MajorName major = Enum.valueOf(MajorName.class,(String)studentJson.get("major"));
                Double gpa = (Double) studentJson.get("gpa");
                Scholarship scholarship = Scholarship.Hope;
                ArrayList<Course> failedCourses = (ArrayList<Course>) studentJson.get("failedCourse");
                ArrayList<Course> currentCourses = (ArrayList<Course>) studentJson.get("currentCourses");
                // Hashmap cast needs to be checked for json (not correct atm)
                //HashMap<Course, Grade> completedCourses = (HashMap<Course, Grade>) studentJson.get("completedCourses");
                HashMap<Course, Grade> completedCourses = null;

                UserList.students.add(new Student(user_UUID, userName, password, firstName,lastName, uscID,
                gradYear, major, gpa, scholarship, failedCourses, currentCourses, completedCourses));
            }
        } catch (IOException | ParseException e) {
            ((Throwable) e).printStackTrace();
            // Handle exceptions
        }

        return UserList.students;
    }
    public ArrayList<Advisor> getAllAdvisors(String filePath) {
        ArrayList<Advisor> advisors = new ArrayList<>();

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
                UUID user_UUID = (UUID) advisorJson.get("user_UUID");
                ArrayList<Student> students = (ArrayList<Student>) advisorJson.get("Students");
                // Create Advisor object passing the list of students
                advisors.add(new Advisor(students,userName,password,firstName,lastName,uscID,user_UUID));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            // Handle exceptions
        }

        return advisors;
    }
}
