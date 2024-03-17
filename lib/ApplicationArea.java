package lib;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ApplicationArea {
    public String applicationArea;
    public ArrayList<Course> requiredCourses;
    public CourseList courseList = CourseList.getInstance();
    Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
        Set<String> selectedCourses = new HashSet<>();
        requiredCourses.clear(); // Clears the list to ensure it's empty before adding new courses.
    
        System.out.println("Enter the application area:");
        String applicationArea = scanner.nextLine().trim();
    
        switch (applicationArea) {
            case "Bioinformatics":
                System.out.println("Select three unique courses from the following list for Bioinformatics:");
                System.out.println("BIOL 302, BIOL 301, BIOL 303, CHEM 333");
                break;
            case "Cloud Native Application Development":
                System.out.println("Select three unique courses from the following list for Cloud Native Application Development:");
                System.out.println("MGMT 371, MGMT 374, MGMT 376, MGMT 402, MGMT 403");
                break;
            case "Computer Game Design and Development":
                System.out.println("Select three unique courses from the following list for Computer Game Design and Development:");
                System.out.println("MART 201, MART 210, MART 380, MART 581D, MART 371, MART 571C, MATH 527, MATH 576");
                break;
            case "Data Scientist":
                System.out.println("Select three unique courses from the following list for Data Scientist:");
                System.out.println("STAT 530, STAT 511, STAT 535, STAT 512, STAT 513");
                break;
            case "Cybersecurity":
                System.out.println("Select three unique courses from the following list for the Cybersecurity program:");
                System.out.println("CRJU 313, CRJU 314, CRJU 341, LAWS 525, LAWS 526, LAWS 547, JOUR 303, JOUR 504");
                break;
            case "Geographic Information Systems Developer":
                System.out.println("Select three unique courses from the following list for GIS Developer:");
                System.out.println("GEOG 341, GEOG 345, GEOG 363, GEOG 541, GEOG 551, GEOG 562, GEOG 563, GEOG 564");
                break;
            case "Linguistics":
                System.out.println("Select three unique courses from the following list for Linguistics:");
                System.out.println("LING 340, LING 421, LING 440, LING 565, LING 567");
                break;
            case "New Media":
                System.out.println("Select three unique courses from the following list for New Media:");
                System.out.println("MART 201, MART 210, MART 371, MART 380");
                break;
            case "Risk and Insurance":
                System.out.println("Select three unique courses from the following list for Risk and Insurance:");
                System.out.println("FINA 363, FINA 341, FINA 442, FINA 443, FINA 444, FINA 445");
                break;
            case "Aerospace Engineering":
                System.out.println("Select three unique courses from the following list for Aerospace Engineering:");
                System.out.println("EMCH 577, EMCH 578, EMCH 508, EMCH 585");
                break;
            case "Robotics":
                System.out.println("Select three unique courses from the following list for Robotics:");
                System.out.println("EMCH 535, ELCT 331, ELCT 531");
                break;
            default:
                System.out.println("Application area not recognized or does not require course selection. No courses added.");
                return; // Exits the method if not valid
        }
    
        System.out.println("Enter the course IDs one by one:");
        while (selectedCourses.size() < 3) {
            String courseID = scanner.nextLine().trim().toUpperCase();
            System.out.println("Attempting to add: " + courseID);
            // checks if the courseID is already selected to ensure uniqueness.
            if (!selectedCourses.contains(courseID) && courseList.getCourse(courseID)!= null ) {
                selectedCourses.add(courseID);
                requiredCourses.add(courseList.getCourse(courseID));
                if (selectedCourses.size() < 3) {
                    System.out.println(courseID + " added. Please enter the next course ID:");
                }
            } else if (courseList.getCourse(courseID)== null) {
                System.out.println("You have entered an incorrect name. Please enter a different course ID:");
            }
              else {
                System.out.println("You have added this course. Please enter a different course ID:");
              }
        }
        System.out.println("All required courses have been selected.");
    }
    
    

}