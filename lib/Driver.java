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

    Driver() throws FileNotFoundException, ParseException, IOException {
        scanner = new Scanner(System.in);
        progressPilot = new ProgessPilotFACADE();
        dataLoader = new DataLoader();
        dataLoader.getAllStudents("json/json_examples/student_ex.json");
        dataLoader.getAllAdvisors("json/json_examples/admin_ex.json");
    }
    /**
     * Type '1' to sign up type '2' to login
    */
    
    public void run() {
        System.out.println(WELCOME_MESSAGE);
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
private int loginType (int numCommands) {
    System.out.print("Login as a student or advisor? ");
    String userIn = scanner.nextLine();
    int command = Integer.parseInt(userIn) - 1;
    
    if(command >= 0 && command <= numCommands -1) return command;
    
    return -1;
}
private int getUserCommand(int numCommands) {
    System.out.print("What would you like to do?: ");
    
    String input = scanner.nextLine();
    int command = Integer.parseInt(input) - 1;
    
    if(command >= 0 && command <= numCommands -1) return command;
    
    return -1;
}
/**
 * Type '1' for student login
 * Type '2' for advisor login
 */
private void login() {
    boolean run = true;
    int userCommand = loginType(loginOptions.length);
    if (userCommand == -1) {
        System.out.println("Not a valid command");
    }
    switch(userCommand) {
        case(0):
            System.out.println("Student Login: ");
            studentLogin();
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
private void studentLogin() {
    String userName = getField("Username");
    String password = getField("password");
    progressPilot.studentLogin(userName, password);
        Student currentStudent = progressPilot.studentLogin(userName, password);
        System.out.println("Welcome " + currentStudent.getFirstName() + " " + currentStudent.getLastName() + "!");
}
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