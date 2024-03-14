package lib;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Driver {
    private static final String WELCOME_MESSAGE = "Welcome to Progress Pilot!";
    private String[] mainMenuOptions = {"Create Account", "Login"};
    private String[] loginOptions = {"Student", "Advisor"};
    private Scanner scanner;
    private ProgessPilotFACADE progressPilot;
    private DataLoader dataLoader;
    private DataWriter dataWriter;
    private Student currentStudent;

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
        System.out.println("Press '1' for sign up or press '2' for login");
        int userCommand = getUserCommand(mainMenuOptions.length);
        if (userCommand == -1) {
            System.out.println("Not a valid command");
        }
        switch(userCommand) {
            case(0):
                createAccount();
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
    System.out.print("Login as a student or advisor? \n'1' for student or '2' for advisor ");
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

private String getField(String prompt) {
    System.out.print(prompt + ": ");
    return scanner.nextLine();
}
/**
 * Takes in input from user and creates a new user with the information
 */
private void createAccount() {
    String userName = getField("Username");
    String password = getField("Password");
    String firstName = getField("First Name");
    String lastName = getField("Last Name");
    String uscID = getField("USC ID");
    if(progressPilot.createAccount(userName, password, firstName, lastName, uscID)) {
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
    String password = getField("password");
    progressPilot.studentLogin(userName, password);
        currentStudent = progressPilot.studentLogin(userName, password);
        dataWriter.saveAllStudents();
        System.out.println("Welcome " + currentStudent.getFirstName() + " " + currentStudent.getLastName() + "!");
        studentOptions();
}
private int studentChoice(int numCommands) {
    System.out.print("Student Choices \n'1' View courses taken and grades earned or '2' Courses that need to be taken ");
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
    int userCommand = studentChoice(loginOptions.length);
    if (userCommand == -1) {
        System.out.println("Not a valid command");
    }
    switch(userCommand) {
        case(0):
            System.out.println("View Courses: ");
            //currentStudent.getCompletedCourses();
            dataWriter.saveAllStudents();
            break;

        case(1):
            System.out.println("Courses that need to be taken: ");
            //currentStudent.getCoursesRemaining();
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
/**
 * Takes in username and password and checks the advisor array list to see if the profile
 * exist and if it does it signs them in
 */
private void advisorLogin() {
    String userName = getField("Username");
    String password = getField("password");
    progressPilot.advisorLogin(userName, password);
        Advisor currentAdvisor = progressPilot.advisorLogin(userName, password);
        System.out.println("Welcome " + currentAdvisor.getFirstName() + " " + currentAdvisor.getLastName() + "!");
}
public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {
    Driver ppInterface = new Driver();
    ppInterface.run();
}
}