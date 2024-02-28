package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Student extends User{
  private String gradYear;
  private Major major;
  private MajorName majorName;
  private Double gpa;
  private ArrayList<Scholarship> scholarships;
  private ArrayList<Course> failedCourses;
  private ArrayList<Course> currentCourses;
  public HashMap<Course, Grade> completedCourses;

  public Student(UUID user_UUID, String userName, String password, String firstName, String lastName, String uscID,
        String gradYear, MajorName major, Double gpa) {
        super(userName, password, firstName, lastName, uscID, user_UUID);
        this.gradYear = gradYear;
        this.majorName = major;
        this.gpa = gpa;
        this.scholarships = new ArrayList<>();
        this.failedCourses = new ArrayList<>();
        this.currentCourses = new ArrayList<>();
        this.completedCourses = new HashMap<>();
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
  public String getPassword() {
    return password;
  }
public String getId() {
    return this.uscID;
}
public String getGradYear() {
    return this.gradYear;
}
}
