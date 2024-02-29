package lib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Course {
    public String courseCode;
    public String courseNumber;
    public String fullName;
    public ArrayList<String> courseAttributes;
    public String[] courseDescription;
    public int creditHours;
    public boolean isTransfer;
    public UUID courseID;
    private ArrayList<HashMap<Course, Double>> prereqs;

    public Course(String courseCode, String courseNumber, String courseDescription, int creditHours) {
    fullName = courseCode + " " + courseNumber;
    }

    public boolean isAIU(Course course) {
        return false;
    }

    public boolean isSCI(Course course) {
        return false;
    }

    public boolean isGFL(Course course) {
        return false;
    }

    public boolean isGHS(Course course) {
        return false;
    }

    public boolean isGSS(Course course) {
        return false;
    }

    public boolean isCMS(Course course) {
        return false;
    }

    public boolean isINF(Course course) {
        return false;
    }

    public boolean isFoundingDoc(Course course) {
        return false;
    }

    public boolean isLiberalArts(Course course) {
        return false;
    }

    public Course getPrereq(Course course) {
        return null;
    }
    public String getFullName () {
        return this.fullName;
    }
}
