package lib;

import java.util.ArrayList;
import java.util.UUID;

public class MajorList {
    private ArrayList<Major> major;
    /**
     * Creates a new major based on the requirements
     * @param gpaRequirement required gpa for the major
     * @param totalHours  total hours needed to complete the major
     * @param college college the major resides in
     * @param majorName name of the major from the MajorName enum
     * @param courses courses required to complete the major
     */
    protected void addMajor (UUID majorID, Double gpaRequirement, int totalHours, String college, MajorName majorName, ArrayList<Course> courses) {
        Major newMajor = new Major(majorID, gpaRequirement, totalHours, college, majorName, courses);
        major.add(newMajor);
    }
    /**
     * takes in a major name then checks for it and removes the major
     * @param majorName major name that is going to be removed
     */
    protected void removeMajor (String majorName) {
      for (int i =0; i< major.size(); i++) {
        if (major.get(i).getMajorName().toString().equals(majorName)) {
            major.remove(i);
            System.out.println(majorName + " was Deleted");
        }
      }
    }
    /**
     * @param majorName major name that is being searched for
     * @return returns the name
     */
    protected MajorName getMajor (MajorName majorName) {
        return majorName;
}
}
