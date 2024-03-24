package lib;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Represents an eight-semester academic plan for a student, including major requirements,
 * elective courses, and semester-wise course planning.
 */
public class eightsemesterplan {
    private  ArrayList<Semester> semestersNeeded;
    private Student student;
    protected ArrayList<Course> whatIfCourses;
    protected ArrayList<Course> majorMap;



/**
     * Constructs an EightSemesterPlan for a given student and initial set of courses.
     *
     * @param student The student for whom the plan is being created.
     * @param takeCourses The initial set of courses to take.
 * @return 
     */
    public Object EightSemesterPlan (Student student, ArrayList<Course> takeCourses ) {
        return null;
}


      /**
     * Retrieves the major map for a specified major.
     *
     * @param major The major for which the major map is requested.
     * @return An ArrayList of Courses representing the major map.
     */
    public ArrayList<Course> getMajorMap (Major major) {
      return null;
}
 /**
     * Computes and returns the completed part of the major map with grades.
     *
     * @return A HashMap mapping Courses to Grades representing completed courses in the major map.
     */
public HashMap <Course, Grade> completedMajorMap () {
    return null;
}
 /**
     * Adds a semester to the plan.
     *
     * @param semester The semester to add to the plan.
     */
protected void addSemester (Semester semester) {

}
/**
     * Removes a semester from the plan.
     *
     * @param semester The semester to be removed from the plan.
     */
protected void removeSemester (Semester semester) {

}
/**
     * Saves the plan with a given list of courses.
     *
     * @param courses The courses to be saved in the plan.
     */
protected void savePlan(ArrayList<Course> courses) {

}
/**
     * Deletes a plan associated with a given list of courses.
     *
     * @param courses The courses associated with the plan to be deleted.
     */
protected void deletePlan(ArrayList<Course> courses) {

}
/**
     * Retrieves the plan for a given student.
     *
     * @param student The student whose plan is to be retrieved.
     * @return An ArrayList of Courses representing the student's plan.
     */
protected ArrayList<Course> getPlan (Student student) {
  return null;
}
 /**
     * Prints the academic transcript for the student, including completed and in-progress courses.
     */
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
      /**
 * Represents a hypothetical academic plan ("What If" scenario) for a student considering a different major,
 * allowing the student to see how completed and planned courses would apply towards the requirements of
 * a different major.
 */
class whatIf {
    /**
     * Constructs a WhatIf scenario for evaluating a student's academic plan against a different major.
     *
     * @param student The student for whom the "What If" scenario is being created.
     * @param major The new major to consider for the "What If" scenario.
     */
    public whatIf (Student student, Major major) {
        
    }

}
/**
 * Creates a "What If" scenario for a student considering a different major, allowing the student
 * to explore how changing majors could affect their academic plan.
 *
 * @param student The student for whom the "What If" scenario is being created.
 * @param major The new major to consider for the "What If" scenario.
 */
protected void createWhatIf (Student student, Major major) {

}
/**
 * Deletes a previously created "What If" scenario, removing it from consideration in the student's academic planning.
 *
 * @param whatIf The "What If" scenario to delete.
 */
protected void deleteWhatIf (whatIf whatIf) {

}

}
