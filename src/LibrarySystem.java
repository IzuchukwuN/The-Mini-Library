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
        System.out.print("Your library card number is: ");
        return (int)(Math.random()*(Integer.MAX_VALUE-1000000000))+1000000000;
    }
    public static void libraryCardCreation() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Mini Library!");
            System.out.println("1. Create a library card");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();


            switch (choice) {
                case "enter":
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
    public static void main(String[] args) {
        // Call the library card creation method
        libraryCardCreation();
    }
}


