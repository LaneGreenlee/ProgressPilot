package lib;

import java.util.ArrayList;
import java.util.HashMap;
public class EightSemesterPlan {
    private  ArrayList<Semester> semestersNeeded;
    private Student student;
    protected ArrayList<Course> whatIfCourses;
    protected ArrayList<Course> majorMap;

    public EightSemesterPlan (Student student, ArrayList<Course> takeCourses ) {

}
    public ArrayList<Course> getMajorMap (Major major) {
      return null;
}
public HashMap <Course, Grade> completedMajorMap () {
    return null;
}

protected void addSemester (Semester semester) {

}
protected void removeSemester (Semester semester) {

}
protected void savePlan(ArrayList<Course> courses) {

}
protected void deletePlan(ArrayList<Course> courses) {

}
protected ArrayList<Course> getPlan (Student student) {
  return null;
}
protected void printTranscript() {
        System.out.println("Transcript for: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student ID: " + student.getId());
        System.out.println("Major: " + student.getMajor().getMajorName()); 

        for (Semester semester : semestersNeeded) {
            System.out.println("Semester: "); 
            for (Course course : semester.getCurrentCourses()) {
                Grade grade = student.getCompletedCourses().get(course);
                String gradeStr = (grade != null) ? grade.toString() : "In Progress";
                System.out.println(course.getFullName() + " - " + gradeStr);
            }
        }
      }
class whatIf {
    public whatIf (Student student, Major major) {
        
    }

}
protected void createWhatIf (Student student, Major major) {

}
protected void deleteWhatIf (whatIf whatIf) {

}

}
