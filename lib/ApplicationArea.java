package lib;

import java.util.ArrayList;

public class ApplicationArea {
    public String applicationArea;
    public ArrayList<Course> requiredCourses;

    public ApplicationArea (String applicationArea, ArrayList<Course> requiredCourses) {
        this.applicationArea = applicationArea;
        this.requiredCourses = requiredCourses;
    }
}
