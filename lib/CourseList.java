package lib;

import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    public ArrayList<Course> Courses;
    private DataLoader loader;
    /**
     * Constructor by created ArrayList of courses
     */
    private CourseList() {
       Courses = new ArrayList<Course>();
       loader = new DataLoader();
       Courses = loader.getCourses("json/json_examples/course_ex.json");
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
      String normalizedInput = courseName.trim().toUpperCase(); // Normalize input for comparison
  
      for (int i = 0; i < Courses.size(); i++) {
          String normalizedCourseName = Courses.get(i).getFullName().toUpperCase(); // Normalize stored name
          if (normalizedInput.equals(normalizedCourseName)) {
              return Courses.get(i);
          }
      }
      System.out.println("Sorry, no course was found with that name.");
      return null;
  }
  
    public ArrayList<Course> getGHS() {
      ArrayList<Course> ghsCourses = new ArrayList<Course>();
      for (Course course : Courses) {
          if (course.isGHS(course)){
              ghsCourses.add(course);
          }
      }
      return ghsCourses;
  }
  public ArrayList<Course> getGFL() {
    ArrayList<Course> gflCourses = new ArrayList<Course>();
    for (Course course : Courses) {
        if (course.isGFL(course)){
            gflCourses.add(course);
        }
    }
    return gflCourses;
}
public ArrayList<Course> getGSS() {
  ArrayList<Course> gssCourses = new ArrayList<Course>();
  for (Course course : Courses) {
      if (course.isGSS(course)){
          gssCourses.add(course);
      }
  }
  return gssCourses;
}
public ArrayList<Course> getCMS() {
  ArrayList<Course> cmsCourses = new ArrayList<Course>();
  for (Course course : Courses) {
      if (course.isCMS(course)){
          cmsCourses.add(course);
      }
  }
  return cmsCourses;
}
public ArrayList<Course> getAIU() {
  ArrayList<Course> aiuCourses = new ArrayList<Course>();
  for (Course course : Courses) {
      if (course.isAIU(course)){
          aiuCourses.add(course);
      }
  }
  return aiuCourses;
}
public ArrayList<Course> getINF() {
  ArrayList<Course> infCourses = new ArrayList<Course>();
  for (Course course : Courses) {
      if (course.isAIU(course)){
          infCourses.add(course);
      }
  }
  return infCourses;
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
    public ArrayList<Course> getAllAtributes(String attribute) {
      ArrayList<Course> ret = new ArrayList<Course>();
      for (int i =0; i < Courses.size(); i++) {
        if (Courses.get(i).courseAttributes.contains(attribute))
          ret.add(Courses.get(i));
       }
       return ret;
    }
}
 