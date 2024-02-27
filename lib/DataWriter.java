package lib;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter {
    public Boolean saveUsers() {
        return true;
    }
    public Boolean saveCourses() {
        return true;
    }
    public Boolean saveMajors() {
        return true;
    }
        public void saveAllStudents() {
        UserList students = UserList.getInstance();
        ArrayList<Student> studentList = students.getStudents();
        JSONArray jsonUsers = new JSONArray();
		
		// Creation of Objects in JSON 
		for(int i=0; i< studentList.size(); i++) {
			jsonUsers.add(getUserJSON(studentList.get(i)));
		}

        // Write the JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void saveAllAdvisors() {
        UserList advisors = UserList.getInstance();
        ArrayList<Student> advisorList = advisors.getStudents();
        JSONArray jsonUsers = new JSONArray();
		
		// Creation of Objects in JSON 
		for(int i=0; i< advisorList.size(); i++) {
			jsonUsers.add(getStudentJSON(advisorList.get(i)));
		}

        // Write the JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static JSONObject getStudentJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put(USER_ID, student.getId().toString());
        studentDetails.put(USER_TYPE, student.getType());
        studentDetails.put(USER_FIRST_NAME, student.getFirstName());
        studentDetails.put(USER_LAST_NAME, student.getLastName());
        studentDetails.put(USER_USER_NAME, student.getUserName());
        studentDetails.put(USER_EMAIL, student.getEmail());
        studentDetails.put(USER_PASSWORD, student.getPassword());
        studentDetails.put(USER_CURRENT_COURSE_ID, student.getCurrentCourseID().toString());
        studentDetails.put(USER_CURRENT_TOPIC_ID, student.getCurrentTopicID().toString());
        studentDetails.put(USER_CURRENT_LESSON_ID, student.getCurrentLessonID().toString());

        return studentDetails;
    }

}
