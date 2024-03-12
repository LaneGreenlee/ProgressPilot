package lib;

import java.util.ArrayList;

public class ApplicationArea {
    public String applicationArea;
    public ArrayList<Course> requiredCourses;
    /***
     * constructor by taking in application area and required courses
     * @param applicationArea application area the student is pursuing
     * @param requiredCourses courses required for the application area
     */
    public ApplicationArea (String applicationArea, ArrayList<Course> requiredCourses) {
        this.applicationArea = applicationArea;
        this.requiredCourses = requiredCourses;
    }
}
