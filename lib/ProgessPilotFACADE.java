package lib;

import java.util.ArrayList;

public class ProgessPilotFACADE {
    private User user;

    public User login(String userName, String password) {
      this.user = UserList.getUser();
      if (user.getUserName().equals(userName) && user.getPassword().equals(password))
        return user;
      else
        return null;
    }
    public void logout() {

    }
    public boolean isLoggedIn() {
      if (login(user.getUserName(), user.getPassword())!= null)
        return true;
      else
        return false;
    }
    public ArrayList<Course> getAllCourses() {
      return null;
    }
    public ArrayList<Major> getAllMajors() {
      return null;
    }
    public ArrayList<Course> getCourseByMajor (Major major) {
      return null;
    }

}
