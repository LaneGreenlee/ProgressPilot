package lib;
import java.util.ArrayList;
import java.util.UUID;;
public class Semester {
    public UUID semesterID;
    public ArrayList<Course> currentCourses;
    public ArrayList<Course> plan;
    public int totalCreditHours;
    public boolean isComplete;


  
      public Semester(ArrayList<Course> courses) {
        this.semesterID = UUID.randomUUID();
        this.currentCourses = new ArrayList<>(courses);
        this.plan = new ArrayList<>();
        this.totalCreditHours = courses.stream().mapToInt(Course::getCreditHours).sum();
        this.isComplete = false;
    }

    // students should be able to create a course plan for the next semester
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

  protected void addCourse(Course course) {
    if (!currentCourses.contains(course)) {
        currentCourses.add(course);
        totalCreditHours += course.creditHours;
    }
}

protected void removeCourse(Course course) {
  if (currentCourses.remove(course)) {
      totalCreditHours -= course.creditHours;
  }
}

protected void savePlan(ArrayList<Course> courses) {
  this.plan = new ArrayList<>(courses);
}

protected void deletePlan() {
  this.plan.clear();
}
}
