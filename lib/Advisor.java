package lib;
import java.util.ArrayList;
public class Advisor extends User{
    protected ArrayList<Student> students;

    public Advisor(ArrayList<Student> students, String userName, String password, String firstName, String lastName, String uscID) {
      super(userName, password, firstName, lastName, uscID);
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
}
