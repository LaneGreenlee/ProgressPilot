package lib;
import java.util.ArrayList;
import java.util.UUID;
public class Advisor extends User{
    protected ArrayList<Student> students;

    /***
     * Constructor for creating a new advisor
     * takes in all params creates the user and creates new arrayList of students
     * @param userName the user name user to login
     * @param password password used to login
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param uscID  ID given to user by university
     * @param user_UUID  randomly generated to refer to user
     */
    public Advisor(String userName, String password, String firstName, String lastName, String uscID, UUID user_UUID) {
      super(userName, password, firstName, lastName, uscID, user_UUID);
      this.students = new ArrayList<Student>();
    }
    //constructor for loading
    /***
     * Constructor for loading an advisor
     * Creates an advisor from the loaded data and sets equal to all imports
     * @param students students the advisor is responsible for
     * @param userName the user name user to login
     * @param password password used to login
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param uscID  ID given to user by university
     * @param user_UUID  randomly generated to refer to user
     */
    public Advisor(ArrayList<Student> students, String userName, String password, String firstName, String lastName, String uscID, UUID user_UUID) {
      super(userName, password, firstName, lastName, uscID, user_UUID);
      this.students = students;
    }
    
    /***
     * Adds a student to list of students
     * @param student new student who is being added to the list
     */
    protected void addStudent( String username ) {
      students.add(UserList.getStudent(username));
    }
    protected void addStudentByID( String uscID ) {
      students.add(UserList.getStudentUSCID(uscID));
    }
    protected Student getStudentByID (String Id) {
      for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getId().equals(Id))
          return students.get(i);
      }
      return null;
    }
    /***
     * Removes a student from the list
     * @param student student who is being removed
     */
    protected void removeStudent( Student student ) {

    }
    protected void checkStudentProgress(String username) {
      System.out.println(UserList.getStudent(username).toString());
    }
    /***
     * Pass in a String which is the note and a student who's account the note will be put on
     * @param Username student who is being left a note
     * @param notes note being left on the profile
     * @return String which contains notes for student
     */
    protected void addStudentNotes(String username, String notes) {
      this.students.get(this.students.indexOf(UserList.getStudent(username))).addNotes(notes);
    }
    /***
     * takes in a student and then checks course grade to see if any is failing
     * @param student student who is being evaluated if failing
     * @return true if failing, false if not
     */
    protected boolean checkIfFailing(Student student) {
      return false;
    }
    /***
     * The student is assigned a grade for a given course
     * @param student Student who is being given the grade
     * @param course  Course the student earned a grade in
     * @param grade   The grade the student earned
     */
    protected void enterGrade (Student student, Course course, Grade grade) {

    }
    /***
     * Shows students by returning the ArrayList
     * @return ArrayList of students
     */
    protected ArrayList<Student> viewStudents() {
      return students;
    }
    /***
     * Allows advisor to view a course
     * @return a course which contians all information about it
     */
    protected Course viewCourse() {
      return null;
    }
    /***
     * Allows an advisor to create a course
     */
    protected void createCourse() {

    }
    /***
     * Takes in a course then is altered by the advisor
     * @param course takes in the course that needs to be altered
     */
    protected void alterCourse(Course course) {

    }
    /***
     * Takes in a course then removes it
     * @param course course that needs to be removed
     */
    protected void deleteCourse(Course course) {

    }
    /***
     * Takes in a student, then creates an account for them
     * @param student student who's account is being created
     */
    protected void createAccount(Student student) {

    }
    /***
     * takes in a student then modifies their account
     * @param student student who's account is being modified
     */
    protected void  modifyAccount(Student student) {

    }
    /***
     * takes in a student and then deletes the account
     * @param student student who is being removed
     */
    protected void deleteAccount(Student student) {
        
    }
    /***
     * 
     * @return an ArrayList of Strings of the student notes
     */
    public ArrayList<String> printStudentNotes(String username, String notes) {
      return this.students.get(this.students.indexOf(UserList.getStudent(username))).getNotes();
  }

    /***
     * 
     * @return an ArrayList of students
     */
    public ArrayList<Student> getStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudents'");
    }
}
