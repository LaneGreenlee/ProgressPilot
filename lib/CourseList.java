package lib;

import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> Courses;
    private DataLoader loader;
    /**
     * Constructor by created ArrayList of courses
     */
    private CourseList() {
       Courses = new ArrayList<Course>();
       //Courses = loader.getCourses();
    }

    public static CourseList getInstance(){
      if(courseList == null){
        courseList = new CourseList();
      }
      return courseList;
    }
    /**
     * Removes course if a course with the course name exist
     * @param courseName course name that needs to be deleted
     */
    protected void deleteCourse(String courseName) {
        for (int i =0; i < Courses.size(); i++) {
            if (courseName.equals(Courses.get(i).getFullName())) {
              Courses.remove(i);
            }
          }
    }
    /**
     * creates a course based on the passed in values
     * @param courseCode course code of the new course
     * @param courseNumber course number of the new course
     * @param courseDescription course description of the new course
     * @param creditHours credit hours of the new course
     */
    protected void createCourse(String courseCode, String courseNumber, String courseDescription, int creditHours) {
     Courses.add(new Course(courseCode, courseNumber, courseDescription, creditHours));
    }
    /**
     * Passes in a String of course name then searches the course list for the course
     * @param courseName course that is being searched for
     * @return course that has the name of the String passed in 
     */
    protected Course getCourse(String courseName) {
        for (int i =0; i < Courses.size(); i++) {
          if (courseName.equals(Courses.get(i).getFullName())) {
            return Courses.get(i);
          }
        }
        System.out.println("Sorry no course were found with that name");
        return null;
    }

    protected Course getCourse(UUID id) {
      for (int i =0; i < Courses.size(); i++) {
        if (id.equals(Courses.get(i).getCourseID())) {
          return Courses.get(i);
        }
      }
      System.out.println("Sorry no course were found with that name");
      return null;
  }

    /**
     * shows all courses that are in the array list
     * @return array list of all courses
     */
    public ArrayList<Course> getAllCourses() {
      return Courses;
    }

}
