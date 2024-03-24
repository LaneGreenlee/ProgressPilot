package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Student extends User{
  private String gradYear;
  private Major major;
  private MajorName majorName;
  private String userName;
  private Double gpa;
  private Scholarship scholarship;
  private ArrayList<Course> failedCourses;
  private ArrayList<Course> currentCourses;
  public HashMap<Course, Grade> completedCourses;
  private DataLoader loader;
  private ArrayList<String> notes;
  /**
   * The constructor of a brand new student who
   * has not taken any classes
   * @param user_UUID UUID of the student
   * @param userName the username of the student
   * @param password the password fo the student
   * @param firstName the first name of the student
   * @param lastName the last name of the student
   * @param uscID the usc ID of the student
   * @param gradYear the grad year of the student
   * @param major the major of the student
   * @param gpa the gpa of the student
   * @param palmettoFellows the current scholarship of the student
   */
  public Student(UUID user_UUID, String userName, String password, String firstName, String lastName, String uscID,
        String gradYear, MajorName major, Double gpa, lib.Scholarship palmettoFellows) {
        super(userName, password, firstName, lastName, uscID, user_UUID);
        loader = new DataLoader();
        this.userName = userName;
        this.gradYear = gradYear;
        this.majorName = major;
        this.gpa = gpa;
        this.scholarship = palmettoFellows;
        this.failedCourses = new ArrayList<>();
        this.currentCourses = new ArrayList<>();
        this.completedCourses = new HashMap<>();
        this.major = loader.getMajor("json/json_examples/major_ex.json", majorName);
        this.notes = new ArrayList<String>();
        //TODO Auto-generated constructor stub
    }
    /**
     * Constructor for an existing student that is being passed in
     * @param user_UUID UUID of the student
     * @param userName the username of the student
     * @param password the password fo the student
     * @param firstName the first name of the student
     * @param lastName the last name of the student
     * @param uscID the usc ID of the student
     * @param gradYear the grad year of the student
     * @param major the major of the student
     * @param gpa the gpa of the student
     * @param failedCourses array list of any courses the student has failed
     * @param currentCourses array list of the current courses a student is taking
     * @param completedCourses array list of courses the student has completed with grade
     */
  public Student(UUID user_UUID, String userName, String password, String firstName, String lastName, String uscID,
        String gradYear, MajorName major, Double gpa, Scholarship scholarship, ArrayList<Course> failedCourses,
        ArrayList<Course> currentCourses, HashMap<Course, Grade> completedCourses) {
      super(userName, password, firstName, lastName, uscID, UUID.randomUUID());
      loader = new DataLoader();
      this.userName = userName;
      this.gradYear = gradYear;
      this.majorName = major;
      this.gpa = gpa;
      this.scholarship = scholarship;
      this.failedCourses = failedCourses;
      this.currentCourses = currentCourses;
      this.completedCourses = completedCourses;
      this.major = loader.getMajor("json/json_examples/major_ex.json",major);
      this.notes = new ArrayList<String>();
      }
  protected void addEightSemesterPlan() {

  }
  /**
   * @param Gpa gpa to check if it is failing
   * @return true if failing, false if not
   */
  protected boolean isFailing (Double Gpa) {
    return false;
  }
  /**
   * @return the gpa of the student
   */
  public double getGPA() {
    return this.gpa;
  }
  /**
   * passes in a course that the student failed
   * @param failedcourses course passed in that was failed
   * @return a warning message that a course was failed
   */
  public String FailedCourseWarning(Course failedcourses) {
    return null;
  } 
  /**
   * Will compare gpa to scholarship requirements
   * @param gpa takes in gpa to compare to requirements
   * @return warning if needed incase of losing scholarship
   */
  public String scholarshipWarning(double gpa) {
    return null;
  }
  /**
   * 
   * @return true if meets, false if not
   */
  protected boolean meetsRequirements() {
    return false;
  }
  protected ArrayList<String> getNotes () {
    ArrayList<String> ret = new ArrayList<String>();
    for (int i = 0; i< this.notes.size(); i ++) {
    ret.add(this.notes.get(i));
    }
    return ret;
  }
  /**
   * takes in a course and adds it to the array list
   * @param course course that will be added to current course
   */
  protected void addCurrentCourse(Course course) {

  }
  /**
   * returns all completed courses with grades earned
   * @return hashmap of course and grades that are completed
   */
  public HashMap<Course, Grade> getCompletedCourses() {
    return this.completedCourses;
  }
  /**
   * @return the user name of the stuent
   */
public String getUserName() {
    return username;
  }
  /**
   * @return the major and everything that makes it up
   */
  public Major getMajor() {
    return this.major;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @return the usc ID of the student
   */
  public String getId() {
    return this.uscID;
  }
  /**
   * @return grad year of student
   */
  public String getGradYear() {
    return this.gradYear;
  }
  /**
   * @return the scholarship that the student has
   */
  public Scholarship getScholarship() {
    return this.scholarship;
  }
  /**
   * @return array list of all current courses being taken
   */
  public ArrayList<Course> getCurrentCourses() {
    return this.currentCourses;
  }
  /**
   * @return array list of all failed courses
   */
  public ArrayList<Course> getFailedCourses() {
    return this.failedCourses;
  }
  /**
     * @return Arraylist of courses remaining
     */
  public ArrayList<Course> getCoursesRemaining() {
    ArrayList<Course> remaining = new ArrayList<Course>();
    remaining.addAll(major.courses);
    remaining.removeAll(completedCourses.keySet());
    return remaining;
  }
  /**
     * @return MajorName of the student.
     */
  public MajorName getMajorName() {
    return majorName;
  }
  /**
     * @return Boolean if student meets prerequisites
     */
public boolean meetsPrerequisites(Course course) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'meetsPrerequisites'");
}
/**
     * adds notes to students note variable takes in a string
     */
public void addNotes(String notes) {
  this.notes.add(notes);

}
/**
     * @return String containing student progress
     */
public String toString() {
  String ret ="";
  ret += "Username: " + this.userName;
  ret += "Major: " + major.toString() + "\n";
  ret += "GPA: " + this.gpa + "\n";
  ret += "Scholarship: " + this.scholarship.toString() + "\n";
  ret += "Failed Courses: " + "\n";
  for (int i =0; i < this.failedCourses.size(); i++)
  {
    ret += failedCourses.get(i).fullName + "\n";
  }
  ret += "Completed Courses: " + "\n";
  for (Map.Entry<Course, Grade> entry : completedCourses.entrySet()) {
    Course course = entry.getKey();
    Grade grade = entry.getValue();
    ret += course.getFullName() + " - " + grade.toString() + "\n";
  
}
  ret += "Notes: \n";
  for (int i =0; i < notes.size(); i++) {
  ret += notes.get(i) + "\n";
  }

  return ret;
}
public void updateGPA(double d) {
  this.gpa = d;
}

}
