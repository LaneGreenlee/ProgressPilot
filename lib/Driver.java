package lib;


import java.util.Scanner;

public class Driver {
    private static final String WELCOME_MESSAGE = "Welcome to Progress Pilot!";
    private String[] mainMenuOptions = {"Create Account", "Login"};
    private Scanner scanner;
    private ProgessPilotFACADE progressPilot;

    Driver() {
        scanner = new Scanner(System.in);
        progressPilot = new ProgessPilotFACADE();

    }

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

private int getUserCommand(int numCommands) {
    System.out.print("What would you like to do?: ");
    
    String input = scanner.nextLine();
    int command = Integer.parseInt(input) - 1;
    
    if(command >= 0 && command <= numCommands -1) return command;
    
    return -1;
}
private void login() {
    boolean run = true;
    User userOne = new User ("Hello", "World", "Hey", "Man", "P798790");
    User userTwo = new User ("World", "Hello", "Man", "Hey", "P1231");
    progressPilot.userlist.addUser(userOne);
    progressPilot.userlist.addUser(userTwo);
    String userName = getField("Username");
    String password = getField("password");
    progressPilot.login(userName, password);
    if(run) {
        User currentUser = progressPilot.login(userName,password);
        System.out.println("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
    } else {
        System.out.println("Sorry, invalid username ");
    }
}

private String getField(String prompt) {
    System.out.print(prompt + ": ");
    return scanner.nextLine();
}

public static void main(String[] args) {
    Driver ppInterface = new Driver();
    ppInterface.run();
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
}