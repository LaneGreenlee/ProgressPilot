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
    /***
     * Returns an array list of courses
     * @return ArrayList of courses
     */
    public ArrayList<Course> getCourses(String filePath) {
        ArrayList<Course> courses = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray coursesArray = (JSONArray) parser.parse(reader);

            for (Object o : coursesArray) {
                JSONObject courseJson = (JSONObject) o;
                UUID uuid = UUID.fromString((String) courseJson.get("uuid"));
                String subject = (String) courseJson.get("subject");
                String number = (String) courseJson.get("number");
                String name = (String) courseJson.get("name");
                String description = (String) courseJson.get("description");
                int creditHours = (int)Double.parseDouble((String) courseJson.get("credit_hours"));
                

                Course course = new Course(uuid, subject, number, name, coursesArray, description, creditHours, false);
                courses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }

    /**
     * shows all users in the array list
     * @return array list of all users
     */
    public ArrayList<User> getUsers() {
        return new ArrayList<User>();
    }
    /**
     * shows everything required the majors
     * @return array list of all required the majors
     */
    public ArrayList<Major> getMajors() {
        return new ArrayList<Major>();
    }
    /**
     * Reads in the JSON and adds all students in the student JSON to the array list
     * @param filePath String of path to the JSON file that contains the students
     * @return Array List of all students from the JSON
     */
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
    /**
     * Reads for the advisor JSON and adds them to the advisor array list
     * @param filePath String of the file path to the advisors JSON
     * @return array list loaded with all advisors from JSON
     */
    public ArrayList<Advisor> getAllAdvisors(String filePath) {

        try {
            FileReader reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            //JSONObject jsonObject = (JSONObject) obj;

            JSONArray advisorsArray = (JSONArray) new JSONParser().parse(reader);


            for (Object advisorObj : advisorsArray) {
                JSONObject advisorJson = (JSONObject) advisorObj;

                String userName = (String) advisorJson.get("username");
                String password = (String) advisorJson.get("password");
                String firstName = (String) advisorJson.get("firstName");
                String lastName = (String) advisorJson.get("lastName");
                String uscID = (String) advisorJson.get("uscID");
                UUID user_UUID = (UUID) advisorJson.get("user_UUID");
                ArrayList<Student> students = (ArrayList<Student>) advisorJson.get("Students");
                // Create Advisor object passing the list of students
                UserList.advisors.add(new Advisor(students,userName,password,firstName,lastName,uscID,user_UUID));
            }
        } catch (IOException | ParseException e) {
            ((Throwable) e).printStackTrace();
            // Handle exceptions
        }

        return UserList.advisors;
    }
}
