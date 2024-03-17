package lib;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter {
    private static final String STUDENT_FILE_NAME = "students.json";
    private static final String ADVISOR_FILE_NAME = "advisors.json";

    // Constants for JSON keys
    private static final String USER_ID = "id";
    private static final String USER_TYPE = "type";
    private static final String USER_FIRST_NAME = "firstName";
    private static final String USER_LAST_NAME = "lastName";
    private static final String USER_USER_NAME = "userName";
    private static final String USER_PASSWORD = "password";
    private static final String STUDENT_GRAD_YEAR = "gradYear";
    private static final String STUDENT_MAJOR = "major";
    private static final String STUDENT_GPA = "gpa";
    private static final String STUDENT_SCHOLARSHIPS = "scholarships";
    private static final String STUDENT_FAILED_COURSES = "failedCourses";
    private static final String STUDENT_CURRENT_COURSES = "currentCourses";
    private static final String STUDENT_COMPLETED_COURSES = "completedCourses";
    // Additional constants for Advisor-specific fields
    /**
     * Creates instance of userlist and adds all students to the student list.
     * Creates new JSONArray and adds students to this Array
     * Writes to JSON using private method
     */
    public void saveAllStudents() {
        //UserList students = UserList.getInstance();
        //ArrayList<Student> studentList = students.getAllStudents();
        JSONArray jsonStudents = new JSONArray();

        for (Student student : UserList.students) {
            jsonStudents.add(getStudentJSON(student));
        }

        writeToFile(jsonStudents, STUDENT_FILE_NAME);
    }

    /**
     * Creates instance of userlist and adds all advisor to the advisor list.
     * Creates new JSONArray and adds advisor to this Array
     * Writes to JSON using private method
     */
    public void saveAllAdvisors() {
        UserList advisors = UserList.getInstance();
        ArrayList<Advisor> advisorList = advisors.getAllAdvisors(); // Assuming there's a method to get advisors
        JSONArray jsonAdvisors = new JSONArray();

        for (Advisor advisor : advisorList) {
            jsonAdvisors.add(getAdvisorJSON(advisor));
        }

        writeToFile(jsonAdvisors, ADVISOR_FILE_NAME);
    }
    /**
     * Puts all of the student attributes into the JSON object then writes
     * to the JSON file
     * @param student Student passed in to then be saved to JSON object
     * @return returns JSONObject that is then written to the file
     */
    private static JSONObject getStudentJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put(USER_ID, student.getId().toString());
        studentDetails.put(USER_TYPE, "Student");
        studentDetails.put(USER_FIRST_NAME, student.getFirstName());
        studentDetails.put(USER_LAST_NAME, student.getLastName());
        studentDetails.put(USER_USER_NAME, student.getUserName());
        studentDetails.put(USER_PASSWORD, student.getPassword());
        studentDetails.put(STUDENT_GRAD_YEAR, student.getGradYear());
        studentDetails.put(STUDENT_SCHOLARSHIPS, student.getScholarship());
        studentDetails.put(STUDENT_MAJOR, student.getMajorName());
        studentDetails.put(STUDENT_GPA, student.getGPA());
        // Handle scholarships, failedCourses, currentCourses, completedCourses appropriately
        // For lists and maps, you might need to convert them to JSONArray or JSONObject
        JSONArray failedCoursesArray = new JSONArray();
        for(Course course : student.getFailedCourses()) {
            failedCoursesArray.add(course.getCourseID());
        }
        
        studentDetails.put(STUDENT_FAILED_COURSES, failedCoursesArray);

        JSONArray currentCoursesArray = null;
        /*for (Course course : student.getCurrentCourses()) {
            JSONObject courseObject = new JSONObject();
            courseObject.put("courseName", course.getFullName());
            courseObject.put("courseGrade", course.getGrade());
            currentCoursesArray.add(courseObject);
        }
        */
        studentDetails.put(STUDENT_CURRENT_COURSES, currentCoursesArray);

        JSONObject completedCoursesObject = null;
        /*
        for (HashMap.Entry<Course, Grade> entry : student.getCompletedCourses().entrySet()) {
            Course course = entry.getKey();
            Grade grade = entry.getValue();
            completedCoursesObject.put(course.getFullName(), grade);
        }
        */
        studentDetails.put(STUDENT_COMPLETED_COURSES, completedCoursesObject);

        return studentDetails;
    }

    /**
     * Puts all of the advisor attributes into the JSON object then writes
     * to the JSON file
     * @param advisor advisor passed in to then be saved to JSON object
     * @return returns JSONObject that is then written to the file
     */
    private JSONObject getAdvisorJSON(Advisor advisor) {
        JSONObject advisorDetails = new JSONObject();
        // Populate advisor-specific details
        // For example:
        advisorDetails.put(USER_TYPE, "Advisor");
        // Handle advisor's students list
        JSONArray studentsJson = new JSONArray();
        for (Student student : advisor.getStudents()) {
            studentsJson.add(student.getId().toString()); // Or more detailed information if needed
        }
        advisorDetails.put("students", studentsJson);

        return advisorDetails;
    }
    /**
     * Private helper file to write to file
     * @param jsonData JSON array created by saveAllAdvisors and saveAllStudents
     * @param fileName String to file path to which it is being written to
     */
    private void writeToFile(JSONArray jsonData, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonData.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveCourses(ArrayList<Course> courses, String filePath) {
        JSONArray jsonCourses = new JSONArray();

        for (Course course : courses) {
            JSONObject courseJson = new JSONObject();
            courseJson.put("uuid", course.getCourseID().toString());
            courseJson.put("subject", course.getCourseCode());
            courseJson.put("number", course.getCourseNumber());
            courseJson.put("name", course.getFullName());
            courseJson.put("description", course.getDescription());
            courseJson.put("credit_hours", String.valueOf(course.getCreditHours()));
            // Assume handling for isTransfer and courseAttributes if applicable
            
            // Handle semestersOffered, prerequisites, corequisites

            jsonCourses.add(courseJson);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonCourses.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
