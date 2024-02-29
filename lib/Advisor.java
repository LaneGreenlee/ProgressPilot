package lib;
import java.util.ArrayList;
import java.util.UUID;
public class Advisor extends User{
    protected ArrayList<Student> students;

    // constrcutor for creating new advisor
    public Advisor(String userName, String password, String firstName, String lastName, String uscID, UUID user_UUID) {
      super(userName, password, firstName, lastName, uscID, user_UUID);
      this.students = new ArrayList<Student>();
    }
    //constructor for loading
    public Advisor(ArrayList<Student> students, String userName, String password, String firstName, String lastName, String uscID, UUID user_UUID) {
      super(userName, password, firstName, lastName, uscID, user_UUID);
      this.students = students;
    }

    public String addNotes(String note, Student student ) {
      return null;
    }

    protected void addStudent( Student student ) {
      students.add(student);
    }

    protected void removeStudent( Student student ) {

    }

    protected boolean checkIfFailing(Student student) {
      return false;
    }
    protected void enterGrade (Student student, Course course, Grade grade) {

    }
    protected ArrayList<Student> viewStudents() {
      return students;
    }
    protected Course viewCourse() {
      return null;
    }
    protected void createCourse() {

    }
    protected void alterCourse(Course course) {

    }
    protected void deleteCourse(Course course) {

    }
    protected void createAccount(Student student) {

    }
    protected void  modifyAccount(Student student) {

    }
    protected void deleteAccount(Student student) {
        
    }

    public Student[] getStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudents'");
    }
}
