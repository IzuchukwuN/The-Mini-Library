import java.util.Scanner;

public class LibrarySystem {
    private String username;
    private String password;

    // Getter and setter for username
    /**
     * Getter for the username.
     * @return The username.
     */
    private String getUsername() {
        return username;
    }

    /**
     * Setter for the username.
     * @param username The username to set.
     */
    private void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    /**
     * Getter for the password.
     * @return The password.
     */
    private String getPassword() {
        return password;
    }

    /**
     * Setter for the password.
     * @param password The password to set.
     */
    private void setPassword(String password) {
        this.password = password;
    }

    // Method that creates a random 9-digit number
    /**
     * Generates a random 9-digit number.
     * @return A random 9-digit number.
     */
    public int cardNum(){
        return (int)(Math.random()*(Integer.MAX_VALUE-1000000000))+1000000000;
    }

    public static void libraryCardCreation() {
        LibrarySystem num = new LibrarySystem();
        LibraryGuide book = new LibraryGuide();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Mini Library!");
            System.out.println("1. Input Enter to Create a library card");
            System.out.println("2. Input Exit to leave");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "enter":
                    // Generate random username and password
                    System.out.print("Enter a username: ");
                    String username = scanner.nextLine();
                    num.setUsername(username);

                    System.out.print("Enter a password: ");
                    String password = scanner.nextLine();
                    num.setPassword(password);

                    // Display username, password, and library card number
                    System.out.println("Your username is: " + num.getUsername());
                    System.out.println("Your password is: " + num.getPassword());
                    int number = num.cardNum();
                    System.out.println("Your library card number is: " + number);
                    System.out.println("Library card created successfully!");
                    System.out.println("Hello I will be your guide, here is my information");
                    LibraryGuide guide = new LibraryGuide("Name: Thomas","Email: thomas@gmail.com","ID: 4729844924","Phone number: 240-956-3728");
                    System.out.println("Lets get started");
                    book.Guide();
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
}
