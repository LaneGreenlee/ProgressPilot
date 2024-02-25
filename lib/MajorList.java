package lib;

import java.util.ArrayList;

public class MajorList {
    private ArrayList<Major> major;
    protected void addMajor (Double gpaRequirement, int totalHours, String college, MajorName majorName, ArrayList<Course> courses) {
        Major newMajor = new Major(gpaRequirement, totalHours, college, majorName, courses);
        major.add(newMajor);
    }
    protected void removeMajor (Major major) {

    }
    protected MajorName getMajor (MajorName majorName) {
        return majorName;
}
}
