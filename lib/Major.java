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
    public CourseList courselist;
    public ApplicationArea applicationArea;
    
    public Major (Double gpaRequirement, int totalHours, String college, MajorName majorName, ArrayList<Course> courses) {
      this.gpaRequirement = gpaRequirement;
      this.totalHours = totalHours;
      this.college = college;
      this. majorName = majorName;
      this.courses = courses;
    }
    public MajorName getMajorName () {
        return this.majorName;
    }
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
            courses.remove(courselist.getCourse("Application Area"));
            courses.remove(courselist.getCourse("Application Area"));
            courses.remove(courselist.getCourse("Application Area"));
            courses.addAll(applicationArea.requiredCourses);
    }
    

  
    public String toString(){
      String ret = "";
      ret += "Major Name:" + majorName;
      ret += "\nTotal Hours: " + totalHours;
      ret += "\nCollege: " + college;
      ret += "\nMajorID: " + majorID;
      return ret;
    }
}
