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

    }
    public MajorName getMajorName () {
        return this.majorName;
    }
    public void addApplicationArea (ApplicationAreaEnum apArea) {

    }
    public String toString(){
      return null;
    }
}
