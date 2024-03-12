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
            
          case Cloud_Native_Application_Development:

          case Computer_Game_Design_and_Development:

          case Data_Scientist:
          
          case Cybersecurity:

          case Geographic_Information_Systems_Developer:

          case Linguistics:

          case New_Media:

          case Risk_and_Insurance:

          case Scientific_Computing:

          case Aerospace_Engineering:
          
          case Robotics:
          
          case Web_Developer:
             
              break;
          default:
              // handle any cases not matched above
              break;
      }
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
