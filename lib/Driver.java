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
                //createAccount();
                break;
            case(1):
                login();
                break;
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
    String userName = getField("Username");
    String password = getField("password");
    progressPilot.login(userName, password);
    if( progressPilot.isLoggedIn()) {
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
}