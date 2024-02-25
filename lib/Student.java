package lib;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User{
  private String gradYear;
  private Major major;
  private Double gpa;
  private ArrayList<Scholarship> Scholarships;
  private ArrayList<Course> failedCourses;
  private ArrayList<Course> currentCourses;
  public HashMap<Course, Grade> completedCourses;



  public Student(String userName, String password, String firstName, String lastName, String uscID) {
        super(userName, password, firstName, lastName, uscID);
        //TODO Auto-generated constructor stub
    }
  protected void addEightSemesterPlan() {

  }
  protected boolean isFailing (Double Gpa) {
    return false;
  }
  public double getGPA() {
    return this.gpa;
  }
  public String FailedCourseWarning(Course failedcourses) {
    return null;
  } 
  public String scholarshipWarning(double gpa) {
    return null;
  }
  protected boolean meetsRequirements() {
    return false;
  }
  protected void addCurrentCourse(Course course) {

  }
  public HashMap<Course, Grade> getCompletedCourses() {
    return this.completedCourses;
  }
  public Major getMajor() {
    return this.major;
  }

    
}
