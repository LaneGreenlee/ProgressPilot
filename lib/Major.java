package lib;

import java.util.ArrayList;
import java.util.UUID;

public class Major {
    public Double gpaRequirement;
    public int totalHours;
    public String college;
    public ArrayList<Course> courses;
    public MajorName majorName;
    public UUID majorID;
    public ApplicationArea applicationArea;
    public CourseList courseList;
    /**
     * constructor to create a major based on the requirements
     * @param gpaRequirement required gpa for the major
     * @param totalHours  total hours needed to complete the major
     * @param college college the major resides in
     * @param majorName name of the major from the MajorName enum
     * @param courses courses required to complete the major
     */
    public Major (UUID majorID, Double gpaRequirement, int totalHours, String college, MajorName majorName, ArrayList<Course> courses) {
      this.majorID = majorID;
      this.gpaRequirement = gpaRequirement;
      this.totalHours = totalHours;
      this.college = college;
      this. majorName = majorName;
      this.courses = courses;
    }
    /**
     * @return the major name
     */
    public MajorName getMajorName () {
        return this.majorName;
    }
    /**
     * passes in the application area that is being added and then adds it to the
     * students profile
     * @param apArea application area that is being added
     */
    public void addApplicationArea(ApplicationAreaEnum apArea) {
      switch (apArea) {
        case Bioinformatics:
            this.applicationArea.applicationArea = "Bioinformatics";
            break;
        case Cloud_Native_Application_Development:
            this.applicationArea.applicationArea = "Cloud Native Application Development";
            break;
        case Computer_Game_Design_and_Development:
            this.applicationArea.applicationArea = "Computer Game Design and Development";
            break;
        case Data_Scientist:
            this.applicationArea.applicationArea = "Data Scientist";
            break;
        case Cybersecurity:
            this.applicationArea.applicationArea = "Cybersecurity";
            break;
        case Geographic_Information_Systems_Developer:
            this.applicationArea.applicationArea = "Geographic Information Systems Developer";
            break;
        case Linguistics:
            this.applicationArea.applicationArea = "Linguistics";
            break;
        case New_Media:
            this.applicationArea.applicationArea = "New Media";
            break;
        case Risk_and_Insurance:
            this.applicationArea.applicationArea = "Risk and Insurance";
            break;
        case Scientific_Computing:
            this.applicationArea.applicationArea = "Scientific Computing";
            break;
        case Aerospace_Engineering:
            this.applicationArea.applicationArea = "Aerospace Engineering";
            break;
        case Robotics:
            this.applicationArea.applicationArea = "Robotics";
            break;
        case Web_Developer:
            this.applicationArea.applicationArea = "Web Developer";
            break;
        default:
            // handle any cases not matched above
            break;}
            this.applicationArea.setRequiredCourses();
            courses.remove(courseList.getCourse("Application Area"));
            courses.remove(courseList.getCourse("Application Area"));
            courses.remove(courseList.getCourse("Application Area"));
            courses.addAll(applicationArea.requiredCourses);
    }
    
    /**
     * @return String containing major name total major hours, college name, and major id. 
     */
  
    public String toString(){
      String ret = "";
      ret += "Major Name:" + majorName;
      ret += "\nTotal Hours: " + totalHours;
      ret += "\nCollege: " + college;
      ret += "\nMajorID: " + majorID;
      return ret;
    }
}
