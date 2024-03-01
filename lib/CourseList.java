package lib;

import java.util.ArrayList;

public class CourseList {
    public ArrayList<Course> courses;
    public CourseList() {
        courses = new ArrayList<Course>();
    }
    protected void deleteCourse(String courseName) {
        for (int i =0; i < Courses.size(); i++) {
            if (courseName.equals(Courses.get(i).getFullName())) {
              Courses.remove(i);
            }
          }
    }
    
    protected void createCourse(String courseCode, String courseNumber, String courseDescription, int creditHours) {
     Courses.add(new Course(courseCode, courseNumber, courseDescription, creditHours));
    }
    protected Course getCourse(String courseName) {
        for (int i =0; i < Courses.size(); i++) {
          if (courseName.equals(Courses.get(i).getFullName())) {
            return Courses.get(i);
          }
        }
        System.out.println("Sorry no course were found with that name");
        return null;
    }
    public ArrayList<Course> getAllCourses() {
      return Courses;
    }

}
