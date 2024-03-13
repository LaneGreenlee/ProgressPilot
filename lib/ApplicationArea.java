package lib;

import java.util.ArrayList;

public class ApplicationArea {
    public String applicationArea;
    public ArrayList<Course> requiredCourses;
    public CourseList courseList;
    /***
     * constructor by taking in application area and required courses
     * @param applicationArea application area the student is pursuing
     * @param requiredCourses courses required for the application area
     */
    public ApplicationArea (String applicationArea, ArrayList<Course> requiredCourses) {
        this.applicationArea = applicationArea;
        this.requiredCourses = requiredCourses;
    }
    /**
     * Clears the requireed course list is clear then adds courses based on what
     * application area the student adds to their major
     */
    public void setRequiredCourses() {
        requiredCourses.clear(); // Ensure the list is empty before adding new courses
    
        switch (this.applicationArea) {
            case "Bioinformatics":
                requiredCourses.add(courseList.getCourse("BIOL 302"));
                requiredCourses.add(courseList.getCourse("BIOL 301"));
                requiredCourses.add(courseList.getCourse("CHEM 333"));
                break;
            case "Cloud Native Application Development":
                requiredCourses.add(courseList.getCourse("MGMT 371"));
                requiredCourses.add(courseList.getCourse("MGMT 374"));
                requiredCourses.add(courseList.getCourse("MGMT 376"));
                break;
            case "Computer Game Design and Development":
                requiredCourses.add(courseList.getCourse("MART 201"));
                requiredCourses.add(courseList.getCourse("MART 210"));
                requiredCourses.add(courseList.getCourse("MATH 527"));
                break;
            case "Data Scientist":
                requiredCourses.add(courseList.getCourse("STAT 530"));
                requiredCourses.add(courseList.getCourse("STAT 511"));
                requiredCourses.add(courseList.getCourse("STAT 535"));
                break;
            case "Cybersecurity":
                requiredCourses.add(courseList.getCourse("CRJU 313"));
                requiredCourses.add(courseList.getCourse("LAWS 525"));
                requiredCourses.add(courseList.getCourse("JOUR 303"));
                break;
            case "Geographic Information Systems Developer":
                requiredCourses.add(courseList.getCourse("GEOG 341"));
                requiredCourses.add(courseList.getCourse("GEOG 345"));
                requiredCourses.add(courseList.getCourse("GEOG 363"));
                break;
            case "Linguistics":
                requiredCourses.add(courseList.getCourse("LING 340"));
                requiredCourses.add(courseList.getCourse("LING 421"));
                requiredCourses.add(courseList.getCourse("LING 440"));
                break;
            case "New Media":
                requiredCourses.add(courseList.getCourse("MART 201"));
                requiredCourses.add(courseList.getCourse("MART 210"));
                requiredCourses.add(courseList.getCourse("MART 380"));
                break;
            case "Risk and Insurance":
                requiredCourses.add(courseList.getCourse("FINA 363"));
                requiredCourses.add(courseList.getCourse("FINA 341"));
                requiredCourses.add(courseList.getCourse("FINA 442"));
                break;
            case "Scientific Computing":
                requiredCourses.add(courseList.getCourse("MATH 242"));
                requiredCourses.add(courseList.getCourse("MATH 300"));
                requiredCourses.add(courseList.getCourse("MATH 520"));
                break;
            case "Aerospace Engineering":
                requiredCourses.add(courseList.getCourse("EMCH 577"));
                requiredCourses.add(courseList.getCourse("EMCH 578"));
                requiredCourses.add(courseList.getCourse("EMCH 508"));
                break;
            case "Robotics":
                requiredCourses.add(courseList.getCourse("EMCH 535"));
                requiredCourses.add(courseList.getCourse("ELCT 331"));
                requiredCourses.add(courseList.getCourse("ELCT 531"));
                break;
            case "Web Developer":
                requiredCourses.add(courseList.getCourse("MART 201"));
                requiredCourses.add(courseList.getCourse("MART 210"));
                requiredCourses.add(courseList.getCourse("MART 380"));
                break;
            default:
                System.out.println("Application area not recognized. No courses added.");
                break;
        }
    }
    

}
