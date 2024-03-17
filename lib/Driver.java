package lib;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import org.json.simple.parser.ParseException;

public class Driver {
    private static final String WELCOME_MESSAGE = "Welcome to Progress Pilot!";
    private String[] mainMenuOptions = {"Create Account", "Login"};
    private String[] loginOptions = {"Student", "Advisor"};
    private String[] electiveOptions = {"GHS", "GFL", "AIU","CMS","GSS","INF"};
    private Scanner scanner;
    private ProgessPilotFACADE progressPilot;
    private DataLoader dataLoader;
    private DataWriter dataWriter;
    private Student currentStudent;
    private Advisor currentAdvisor;

    /**
     * Creates scanner, facade variable, data loader variable, data writer variable and then adds all students and all advisors
     * from data loader
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws IOException
     */
    Driver() throws FileNotFoundException, ParseException, IOException {
        scanner = new Scanner(System.in);
        progressPilot = new ProgessPilotFACADE();
        dataLoader = new DataLoader();
        dataWriter = new DataWriter();
        dataLoader.getCourses("json/json_examples/course_ex.json");
        dataLoader.getAllStudents("json/json_examples/student_ex.json");
        dataLoader.getAllAdvisors("json/json_examples/admin_ex.json");
    }
    /**
    * Presents the user with the choice to either sign up or log in
    */
    public void run() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("Press '1' for sign up\nPress '2' for login");
        int userCommand = getUserCommand(mainMenuOptions.length);
        if (userCommand == -1) {
            System.out.println("Not a valid command");
        }
        switch(userCommand) {
            case(0):
                signup();
            case(1):
                login();
            }
        
        System.out.println("Good bye, have a nice day!");
    }
    /**
     * Decides whether signing in as an advisor or student
     * @param numCommands input to show if they are logging in as a student or advisor
     * @return int that the user put in
     */
    private int loginType (int numCommands) {
        System.out.print("Login as a student or advisor?\n'1' for student\n'2' for advisor\n");
        String userIn = scanner.nextLine();
        int command = Integer.parseInt(userIn) - 1;
        
        if(command >= 0 && command <= numCommands -1) return command;
        
        return -1;
    }
    /**
     * Takes in user input to decide whether to go to sign up or log in
     * @param numCommands input to decide whether signing up or logging
     * @return returns an int that the user put in
     */
    private int getUserCommand(int numCommands) {
        System.out.print("What would you like to do?: ");
        
        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;
        
        if(command >= 0 && command <= numCommands -1) return command;
        
        return -1;
    }
    /**
     * Determines which login type it is
     * If user chooses one it checks the student array list and has user type in user name and password
     * If user chooses one it checks the advisor array list and has user type in user name and password
     */
    private void login() {
        int userCommand = loginType(loginOptions.length);
        if (userCommand == -1) {
            System.out.println("Not a valid command");
        }
        switch(userCommand) {
            case(0):
                System.out.println("Student Login: ");
                studentLogin();

                dataWriter.saveAllStudents();
                break;
            case(1):
                System.out.println("Advisor Login: ");
                advisorLogin();
                break;
            }
    }
    private int signupType (int numCommands) {
        System.out.print("Signup as a student or advisor? \n'1' for student or '2' for advisor ");
        String userIn = scanner.nextLine();
        int command = Integer.parseInt(userIn) - 1;
        
        if(command >= 0 && command <= numCommands -1) return command;
        
        return -1;
    }
    private void signup() {
        int userCommand = signupType(loginOptions.length);
        if (userCommand == -1) {
            System.out.println("Not a valid command");
        }
        switch(userCommand) {
            case(0):
                System.out.println("Student Signup: ");
                createAccountStudent();
                break;
            case(1):
                System.out.println("Advisor Signup: ");
                createAccountAdvisor();
                break;
            }
    }
    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
    private void createAccountStudent() {
        String userName = getField("Username");
        String password = getField("Password");
        String firstName = getField("First Name");
        String lastName = getField("Last Name");
        String uscID = getField("USC ID");
        Student newStudent = new Student(UUID.randomUUID(), userName, password, firstName, lastName, uscID, uscID, MajorName.Computer_Science, null, Scholarship.Hope);
        progressPilot.userlist.addStudent(newStudent);
        if(progressPilot.userlist.students.contains(newStudent)) {
            System.out.println("You have successfully created an account");
        } else {
            System.out.println("Sorry an account with that username already exists");
        }
    }
    /**
     * Takes in input from user and creates a new user with the information
     */
    private void createAccountAdvisor() {
        String userName = getField("Username");
        String password = getField("Password");
        String firstName = getField("First Name");
        String lastName = getField("Last Name");
        String uscID = getField("USC ID");
        Advisor newAdvisor = new Advisor(userName, password, firstName, lastName, uscID, UUID.randomUUID());
        progressPilot.userlist.addAdvisor(newAdvisor);
        if(progressPilot.userlist.advisors.contains(newAdvisor)) {
            System.out.println("You have successfully created an account");
        } else {
            System.out.println("Sorry an account with that username already exists");
        }
    }
    /**
     * Takes in username and password and checks the student array list to see if the profile
     * exist and if it does it signs them in
     */
    private void studentLogin() {
        String userName = getField("Username");
        String password = getField("Password");
        progressPilot.studentLogin(userName, password);
            currentStudent = progressPilot.studentLogin(userName, password);
            //dataWriter.saveAllStudents();
            System.out.println("Welcome " + currentStudent.getFirstName() + " " + currentStudent.getLastName() + "!");
            studentOptions();
    }
    private int studentChoice(int numCommands) {
        System.out.print("Student Choices:\n'1' View courses taken and grades earned\n'2' Courses that need to be taken\n'3' View elective courses\n'4' Add a course to be taken\n'5' Add an application area\nYour Choice: ");
        String userIn = scanner.nextLine();
        int command = Integer.parseInt(userIn) - 1;

        if(command >= 0 && command <= numCommands -1)
            return command;
        
        return -1;
    }
    private void studentOptions() {
        boolean run = true;
        int userChoose = 0;
        while (run){
        int userCommand = studentChoice(5);
        if (userCommand == -1) {
            System.out.println("Not a valid command");
        }
        switch(userCommand) {
            case(0):
                System.out.println("View Courses: ");
                HashMap<Course,Grade> completedCourses = currentStudent.getCompletedCourses();
                for (Map.Entry<Course, Grade> entry : completedCourses.entrySet()) {
                    System.out.println("Course Name: " + entry.getKey().getCourseCode() +" "+entry.getKey().getCourseNumber()+ "\t, Grade: " + entry.getValue());
                }
                dataWriter.saveAllStudents();
                break;

            case(1):
                System.out.println("Courses that need to be taken: ");
                ArrayList<Course> remainingCourses = currentStudent.getCoursesRemaining();
            // Print the remaining courses
                System.out.println("Remaining Courses:");
                for (Course course : remainingCourses) {
                    System.out.println(course.getCourseCode() + " " + course.getCourseNumber());
                }
                //System.out.println(currentStudent.getCoursesRemaining());
                break;
            case(2):
                System.out.println("View Electives: ");
                int choice = electiveChoice(electiveOptions.length);
                showElective(choice);
                break;
            case(3):
                System.out.println("Please enter the Course Code you wish to add (CSCE, MATH etc.):");
                studentAddCourse();
                break;
            case(4):
                System.out.println("Press enter, then enter the application area you wish to add");
                addApplicationArea();
                break;
            }
            System.out.println("\nWould you like to continue working?\n '1' for yes, '2' for no");
            String input = scanner.nextLine();
            int command = Integer.parseInt(input);
            if (command == 1){
                userCommand = 0;
                run = true;
            }
            else
                run = false;
        }
    }
    private int electiveChoice(int numCommands) {
        System.out.print("Elective Choices \n'1' View GHS courses \n'2' View GFL courses \n'3' View AIU courses \n'4' View CMS courses \n'5' View GSS courses \n'6' View INF courses \n ");
        String userIn = scanner.nextLine();
        int command = Integer.parseInt(userIn)-1;

        if(command >= 0 && command <= numCommands -1)
            return command;
        
        return -1;
    }
    private void showElective(int numCommand) {
        switch(numCommand) {
            case(0):
                ArrayList<Course> ghsCourses = progressPilot.courseList.getGHS();
                for (Course course : ghsCourses)
                    System.out.println(course.getCourseCode() + " " + course.getCourseNumber());
                break;
            case(1):
                ArrayList<Course> gflCourses = progressPilot.courseList.getGFL();
                for (Course course : gflCourses)
                    System.out.println(course.getCourseCode() + " " + course.getCourseNumber());
                break;
            case(2):
                ArrayList<Course> aiuCourses = progressPilot.courseList.getAIU();
                for (Course course : aiuCourses)
                    System.out.println(course.getCourseCode() + " " + course.getCourseNumber());
                break;
            case(3):
                ArrayList<Course> cmsCourses = progressPilot.courseList.getCMS();
                for (Course course : cmsCourses)
                    System.out.println(course.getCourseCode() + " " + course.getCourseNumber());
                break;
            case(4):
                ArrayList<Course> gssCourses = progressPilot.courseList.getGSS();
                for (Course course : gssCourses)
                    System.out.println(course.getCourseCode() + " " + course.getCourseNumber());
                break;
            case(5):
            ArrayList<Course> infCourses = progressPilot.courseList.getINF();
            for (Course course : infCourses)
                System.out.println(course.getCourseCode() + " " + course.getCourseNumber());
            break;
        }
    }
    public void studentAddCourse() {
        String courseCode = scanner.nextLine();
        System.out.println("Now enter the course number (347, 101 etc.):");
        String courseNumber = scanner.nextLine();
        int gflIndex = -1;
        for (int i = 0; i < currentStudent.getMajor().courses.size(); i++) {
            Course course = currentStudent.getMajor().courses.get(i);
            if (course.getCourseCode().equals("GFL Elective")) {
                gflIndex = i;
                break;
            }
        }
        if (gflIndex != -1) {
            for (Course course : progressPilot.courseList.Courses) {
                if (courseCode.equals(course.getCourseCode()) && courseNumber.equals(course.getCourseNumber())) {
                    // If the course is found, replace the GFL elective with the new course
                    currentStudent.getMajor().courses.set(gflIndex, course);
                    System.out.println("Course successfully added and replaced the GFL elective.");
                    return; // Exit the method once the course is added
                }
            }
            System.out.println("Course not found.");
        } else {
            System.out.println("No GFL elective found to replace.");
        }
    }
    private void addApplicationArea() {
        String apArea = scanner.nextLine();
        ArrayList<Course> apCourses = new ArrayList<Course>();
        ApplicationArea applicationArea = new ApplicationArea(apArea, apCourses);
        applicationArea.setRequiredCourses();
        for (Course applicationCourses : applicationArea.requiredCourses) {
            for (int i = 0; i < currentStudent.getMajor().courses.size(); i++) {
                if (currentStudent.getMajor().courses.get(i).getCourseCode().equals("Application Area Elective")) {
                    currentStudent.getMajor().courses.set(i, applicationCourses);
                    break;
            }
        }
        }
    }
    /**
     * Takes in username and password and checks the advisor array list to see if the profile
     * exist and if it does it signs them in
     */
    private void advisorLogin() {
        String userName = getField("Username");
        String password = getField("password");
        progressPilot.advisorLogin(userName, password);
            currentAdvisor = progressPilot.advisorLogin(userName, password);
            System.out.println("Welcome " + currentAdvisor.getFirstName() + " " + currentAdvisor.getLastName() + "!");
        advisorOptions();
    }
    private int advisorChoice(int numCommands) {
        System.out.print("Advisor Choices \n'1' Add new advisee, '2' View advisee, '3' Add note to advisee\n");
        String userIn = scanner.nextLine();
        int command = Integer.parseInt(userIn) - 1;

        if(command >= 0 && command <= numCommands -1)
            return command;
        
        return -1;
    }
    private void advisorOptions() {
        boolean run = true;
        int userChoose = 0;
        while (run){
        int userCommand = advisorChoice(3);
        if (userCommand == -1) {
            System.out.println("Not a valid command");
        }
        switch(userCommand) {
            case(0):
                System.out.println("Enter new advisee's USCID number: ");
                String adviseeID = scanner.nextLine();
                currentAdvisor.addStudentByID(adviseeID);
                currentStudent = currentAdvisor.getStudentByID(adviseeID);
                if (currentStudent != null) {
                    System.out.println(currentStudent.getUserName() + " successfully added");
                    break;
                } else {
                    System.out.println("Unable to add new advisee, please try again");
                    break;
                }

            case(1):
                System.out.println("View Advisee Courses taken: ");
                HashMap<Course,Grade> completedCourses = currentStudent.getCompletedCourses();
                System.out.println("You are viewing: " + currentStudent.getUserName());
                for (Map.Entry<Course, Grade> entry : completedCourses.entrySet()) {
                    System.out.println("Course Name: " + entry.getKey().getCourseCode() +" "+entry.getKey().getCourseNumber()+ "\t, Grade: " + entry.getValue());
                }
            // Print the remaining courses
                System.out.println("Remaining Courses:");
                ArrayList<Course> remainingCourses = currentStudent.getCoursesRemaining();
                // Print the remaining courses
                    System.out.println("Remaining Courses:");
                    for (Course course : remainingCourses) {
                        System.out.println(course.getCourseCode() + " " + course.getCourseNumber());
                    }
                break;
            case(2):
                System.out.println("Add note to advisee: ");
                System.out.println("What would you like the note to say?");
                String note = scanner.nextLine();
                    currentAdvisor.addStudentNotes(currentStudent.getUserName(), note);
                
                System.out.println("\nProof that the student note is stored for the student");
                for (String notes : currentStudent.getNotes())
                    System.out.println(notes);
                break;
        }
            System.out.println("Would you like to continue working?\n '1' for yes, '2' for no");
            String input = scanner.nextLine();
            int command = Integer.parseInt(input);
            if (command == 1){
                userCommand = 0;
                run = true;
            }
            else
                run = false;
        }
    }
    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {
        Driver ppInterface = new Driver();
        ppInterface.run();
    }
}