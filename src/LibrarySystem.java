import java.util.*;
public class LibrarySystem {
    private String username;
    private String password;

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method that creates a random 9-digit number
    public int cardNum(){
        return (int)(Math.random()*(Integer.MAX_VALUE-1000000000))+1000000000;
    }
    public static void libraryCardCreation() {
        LibrarySystem num = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Mini Library!");
            System.out.println("1. Input " + "Enter " + "to Create a library card");
            System.out.println("2. Input " + "Exit " + "to leave");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "enter":
                    // Generate random username and password
                    System.out.print("Enter a username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter a password: ");
                    String password = scanner.nextLine();
                    // Display username, password, and library card number
                    System.out.println("Your username is: " + username);
                    System.out.println("Your password is: " + password);
                    int number = num.cardNum();
                    System.out.println("Your library card number is: " + number);
                    System.out.println("Library card created successfully!");
                    return;
                case "exit":
                    System.out.println("Exiting the Mini Library!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please input enter or exit.");
                    break;
            }
        }
    }

    /*public static void main(String[] args) {
        libraryCardCreation(); // Call the library card creation method
    }*/

}


