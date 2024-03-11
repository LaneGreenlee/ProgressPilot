package lib;

import java.util.ArrayList;

public class MajorList {
    private ArrayList<Major> major;
    protected void addMajor (Double gpaRequirement, int totalHours, String college, MajorName majorName, ArrayList<Course> courses) {
        Major newMajor = new Major(gpaRequirement, totalHours, college, majorName, courses);
        major.add(newMajor);
    }
    protected void removeMajor (String majorName) {
      for (int i =0; i< major.size(); i++) {
        if (major.get(i).getMajorName().toString().equals(majorName)) {
            major.remove(i);
            System.out.println(majorName + " was Deleted");
        }
      }
    }
    protected MajorName getMajor (MajorName majorName) {
        return majorName;
}
}
