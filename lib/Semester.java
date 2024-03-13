package lib;
import java.util.ArrayList;
import java.util.UUID;;
public class Semester {
    public UUID semesterID;
    public ArrayList<Course> currentCourses;
    public ArrayList<Course> plan;
    public int totalCreditHours;
    public boolean isComplete;


    /**
     * sets the params of the semester including UUID, courses, a new plan, credit hours and complete
     * @param courses array list passed in that contains courses for the given semester
     */
      public Semester(ArrayList<Course> courses) {
        this.semesterID = UUID.randomUUID();
        this.currentCourses = new ArrayList<>(courses);
        this.plan = new ArrayList<>();
        this.totalCreditHours = courses.stream().mapToInt(Course::getCreditHours).sum();
        this.isComplete = false;
    }

    // students should be able to create a course plan for the next semester
    /**
     * It will go through courses that need to be taken and check if a student has taken them
     * if students met the pre reqs, the course will be added
     * @param student passes in the student that has a plan being created
     * @param takeCourses the courses that are going to be involved in the plan
     */
    public void createPlan(Student student, ArrayList<Course> takeCourses) {
      
      for (Course course : takeCourses) {
          if (!plan.contains(course)) {
              // Assume a method exists in Student to check if prerequisites are met (not implemented)
               if(student.meetsPrerequisites(course)) {
                  plan.add(course);
               }
          }
      }
  }
  /**
   * checks if current courses contains the passed in course
   * if it does not, the course is then added to current course
   * @param course passes in a course that will be added to current courses
   */
  protected void addCourse(Course course) {
    if (!currentCourses.contains(course)) {
        currentCourses.add(course);
        totalCreditHours += course.creditHours;
    }
}
/**
 * the course that is passed in will then be removed from current courses
 * @param course course that will be removed from current course
 */
protected void removeCourse(Course course) {
  if (currentCourses.remove(course)) {
      totalCreditHours -= course.creditHours;
  }
}
/**
 * the array list that is passed in will then be written and saved
 * @param courses passed in an array list of courses that is a created plan
 */
protected void savePlan(ArrayList<Course> courses) {
  this.plan = new ArrayList<>(courses);
}
/**
 * Will delete the current plan
 */
protected void deletePlan() {
  this.plan.clear();
}
/**
 * @return an array list of the current courses
 */
protected ArrayList<Course> getCurrentCourses(){
  return this.currentCourses;
}
}
