

import java.util.Scanner;

public class LoginSystem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // [usercount][0] = Username, [usercount][1] = Password
        String[][] users = new String[100][2]; 
        int usercount = 0;
        boolean running = true;
        
        while (running) {
            System.out.println("--- Welcome ---");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("If you don't have an account please register first");
            System.out.print("Please choose an option (1, 2, 3): ");

            String option = scan.nextLine();

            switch (option) {
                case "1":
                    System.out.println("\n--- LOGIN YOUR ACCOUNT ---");
                    System.out.print("Enter Username: ");
                    String loginName = scan.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPass = scan.nextLine();
                    
                    boolean loginSuccess = false;
                    
                    for (int i = 0; i < usercount; i++) {
                        if (users[i][0] != null && 
                            users[i][0].equals(loginName) && 
                            users[i][1].equals(loginPass)) {
                            loginSuccess = true;
                            break;
                        }
                    }
                    System.out.println();
                    if (loginSuccess) {
                        System.out.println("Hello " + loginName + "!");
                    } else {
                        System.out.println("\n Username or Password is Incorrect please try again!");
                    }
                    
                    System.out.println();
                    break;

                case "2":
                    System.out.println("\n--- REGISTER AN ACCOUNT ---");
                    System.out.print("Enter Username: ");
                    String username = scan.nextLine();
                    
                    boolean usernameExist = false;
                    for (int i = 0; i < usercount; i++) {
                        if (users[i][0] != null && users[i][0].equals(username)) {
                            usernameExist = true;
                            break;
                        }
                    }
                    
                    if (usernameExist) {
                        System.out.println("Username already Exist! Try again");
                        System.out.println();
                        break;
                    }

                    System.out.print("Enter Password: ");
                    String password = scan.nextLine();
                    System.out.print("Confirm Password: ");
                    String confirmPassword = scan.nextLine();
                    
                    if (!password.equals(confirmPassword)) {
                        System.out.println("\n Password does not match! Try again");
                        System.out.println();
                        break;
                    }
                    
                    users[usercount][0] = username;
                    users[usercount][1] = password;
                    usercount++;
                    System.out.println("Registration Success!");
                    System.out.println();
                    break;
                
                case "3":
                    System.out.println("\nGoodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid option please try again. Choose 1, 2, 3.");
                    System.out.println();
                    break;
            }
        }
        
        scan.close();
    }
}
