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
    public static ArrayList<Course> getCourses(String filePath) {
        ArrayList<Course> courses = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray coursesArray = (JSONArray) parser.parse(reader);

            for (Object o : coursesArray) {
                JSONObject courseJson = (JSONObject) o;
                UUID uuid = UUID.fromString((String) courseJson.get("courseID"));
                String code = (String) courseJson.get("courseCode");
                String number = (String) courseJson.get("courseNumber");
                String subject = (String) courseJson.get("courseCode");
                String name = (String) courseJson.get("courseCode");
                double creditHours = Double.parseDouble(String.valueOf(courseJson.get("creditHours")));
                int creditHoursInt = (int) creditHours; // Convert double to int 
                JSONArray courseDescriptionArray = (JSONArray) courseJson.get("courseDescription");
                // Extracting the content from the JSONArray
                String courseDescription = (String) courseDescriptionArray.get(0);
                JSONArray courseAttributeArray = (JSONArray) courseJson.get("courseAttributes");
                ArrayList<String> courseAttributes = new ArrayList<String>();
                // Extracting the content from the JSONArray
                for(Object object : courseAttributeArray) {
                    courseAttributes.add((String)object);
                }
                Course course = new Course(uuid, subject, number, name, courseAttributes, courseDescription, creditHoursInt, false);
                courses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
    public Major getMajor(String filePath, MajorName majorNameCheck) {
        Major majors = new Major(null, null, 0, null, null, null);
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray coursesArray = (JSONArray) parser.parse(reader);
            for (Object o : coursesArray) {
                JSONObject majorJson = (JSONObject) o;
                UUID majorID = UUID.fromString((String)majorJson.get("majorID"));
                Double gpaRequirement = (Double) majorJson.get("gpaRequirement");
                int totalHours = 125;
                String college = (String) majorJson.get("college");
                String majorString = (String) majorJson.get("majorName");
                MajorName majorName =  Enum.valueOf(MajorName.class, majorString);
                JSONArray currentCoursesJSON = (JSONArray)majorJson.get("courses");
                ArrayList<Course> courses = new ArrayList<Course>();
                for (Object idObj : currentCoursesJSON) {
                    UUID courseId = UUID.fromString((String)idObj);
                    Course course = CourseList.getInstance().getCourse(courseId);
                    courses.add(course);
                }
                if (majorName.equals(majorNameCheck)) {
                    majors = new Major(majorID,gpaRequirement, totalHours,college, majorName, courses);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return majors;
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
     public static ArrayList<Student> getAllStudents(String filePath) {
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
                //MajorName major = MajorName.Computer_Information_Systems;
                String majorString = (String) studentJson.get("major");
                MajorName major =  Enum.valueOf(MajorName.class, majorString);
                Double gpa = (Double) studentJson.get("gpa");
                Scholarship scholarship = Scholarship.Hope;
                JSONArray failedCoursesJSON = (JSONArray)studentJson.get("failedCourses");
                ArrayList<Course> failedCourses = new ArrayList<Course>();
                for (Object idObj : failedCoursesJSON) {
                    UUID courseId = UUID.fromString((String)idObj);
                    Course course = CourseList.getInstance().getCourse(courseId);
                    failedCourses.add(course);
                }
                JSONArray currentCoursesJSON = (JSONArray)studentJson.get("currentCourses");
                ArrayList<Course> currentCourses = new ArrayList<Course>();
                for (Object idObj : currentCoursesJSON) {
                    UUID courseId = UUID.fromString((String)idObj);
                    Course course = CourseList.getInstance().getCourse(courseId);
                    currentCourses.add(course);
                }
                // HashMap conversion
                JSONObject completedCoursesJSON = (JSONObject) studentJson.get("completedCourses");
                HashMap<Course, Grade> completedCourses = new HashMap<>();
                for (Object courseIdObj : completedCoursesJSON.keySet()) {
                    String courseIdString = (String) courseIdObj;
                    UUID courseId = UUID.fromString(courseIdString);
                    // update later
                    String gradeString = (String) completedCoursesJSON.get(courseIdString);
                    Grade gradeValue =  Enum.valueOf(Grade.class, gradeString);
                    Course course = CourseList.getInstance().getCourse(courseId); 
                    Grade grade = gradeValue; 
                
                    completedCourses.put(course, grade);
                }
                
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
    public static ArrayList<Advisor> getAllAdvisors(String filePath) {

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
