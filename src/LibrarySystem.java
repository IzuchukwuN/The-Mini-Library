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

    // Method to generate a random 6-digit number
    public int generateRandomNumber() {
        return (int) ((Math.random() * 900000) + 100000);
    }

    // Method for library card creation
    public static void libraryCardCreation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Mini Library!");

        // Asking the user whether they want to input their username and password
        System.out.print("Do you want to create your own username and password? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            LibrarySystem library = new LibrarySystem();
            System.out.print("Enter your desired username: ");
            library.setUsername(scanner.nextLine());
            System.out.print("Enter your desired password: ");
            library.setPassword(scanner.nextLine());
            System.out.println("Username and password set successfully!");

            // Printing the username and password using getters
            System.out.println("Username: " + library.getUsername());
            System.out.println("Password: " + library.getPassword());
        } else if (choice.equalsIgnoreCase("no")) {
            // Generating a random password
            LibrarySystem library = new LibrarySystem();
            String randomPassword = Integer.toString(library.generateRandomNumber());
            library.setPassword(randomPassword);
            System.out.println("Randomly generated password: " + library.getPassword());
        } else {
            System.out.println("Invalid choice.");
        }
    }
    // Method that creates a random 9-digit number
    public int cardNum() {
        System.out.print("Your library card number is: ");
        return (int) (Math.random() * (Integer.MAX_VALUE - 1000000000)) + 1000000000;
    }
}
