package lib;

import java.util.ArrayList;
import java.util.UUID;

public class Major {
    public Double gpaRequirement;
    public int totalHours;
    public String college;
    public ArrayList<Course> courses;
    public UUID majorID;
    
    public Major (Double gpaRequirement, int totalHours, String college, MajorName majorName, ArrayList<Course> courses) {

    }
    public MajorName getMajorName (MajorName majorName) {
        return majorName;
    }
    public void addApplicationArea (ApplicationArea apArea) {

    }
}
