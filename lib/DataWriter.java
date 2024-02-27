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
			jsonUsers.add(getUserJSON(advisorList.get(i)));
		}

        // Write the JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_TYPE, user.getType());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_CURRENT_COURSE_ID, user.getCurrentCourseID().toString());
        userDetails.put(USER_CURRENT_TOPIC_ID, user.getCurrentTopicID().toString());
        userDetails.put(USER_CURRENT_LESSON_ID, user.getCurrentLessonID().toString());

        return userDetails;
    }

}
