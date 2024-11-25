import java.util.Scanner;
import ConsoleTable.ct4j;

public class loginSystem {

    private static final int MAX_USERS = 10;
    private static String[] usernames = new String[MAX_USERS];
    private static String[] passwords = new String[MAX_USERS];
    private static int userCount = 0;
    private static boolean isLoggedIn = false;
    private static String loggedInUser = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-------------- Login System Menu -----------------");
            System.out.println("1. Register new user");
            System.out.println("2. Display user table");
            System.out.println("3. Login");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    displayUserTable();
                    break;
                case 3:
                    login();
                    break;
                case 4:
                    logout();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser() {
        if (userCount >= MAX_USERS) {
            System.out.println("User limit reached. Cannot register more users.");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        System.out.print("Enter Confirm Password: ");
        String confirmPassword = input.nextLine();

        if (password.equals(confirmPassword)) {
            usernames[userCount] = username;
            passwords[userCount] = password;
            userCount++;
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Passwords do not match. User registration failed.");
        }
    }

    private static void displayUserTable() {
        var table = new ct4j();
        if (userCount == 0) {
            System.out.println("No users available.");
        } else {
            try {
                String[] header = { "ID", "Username", "Password" };
                table.setHeader(header);

                for (int i = 0; i < userCount; i++) {
                    table.addRow(String.valueOf(i + 1), usernames[i], passwords[i]);
                }
                table.printTable();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        System.out.print("Enter Password: ");
        String password = input.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                isLoggedIn = true;
                loggedInUser = username;
                System.out.println("Login successful. Welcome, " + loggedInUser + "!");
                return;
            }
        }

        System.out.println("Invalid credentials. Login failed.");
    }

    private static void logout() {
        if (isLoggedIn) {
            System.out.println("Logout successful. Goodbye, " + loggedInUser + "!");
            isLoggedIn = false;
            loggedInUser = "";
        } else {
            System.out.println("No user currently logged in.");
        }
    }
}
