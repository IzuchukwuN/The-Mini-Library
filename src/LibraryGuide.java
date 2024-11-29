import java.util.Scanner;
import java.util.*;
/**
 * The LibraryGuide class guides the library users.
 */
public class LibraryGuide extends LibrarySystem {
    // Private variables to store information about a library guide
    private String name;
    private String email;
    private String employeeId;
    private String phoneNumber;

    /**
     * Constructs a LibraryGuide object with provided information.
     *
     * @param name        The name of the library guide.
     * @param email       The email of the library guide.
     * @param employeeId  The employee ID of the library guide.
     * @param phoneNumber The phone number of the library guide.
     */

    // Constructor to initialize the LibraryGuide object with provided values
    public LibraryGuide(String name, String email, String employeeId, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
        System.out.println(name + "\n" + email + "\n" + employeeId + "\n" + phoneNumber);
    }

    /**
     * Default constructor for LibraryGuide.
     */
    public LibraryGuide() {

    }

    public void Guide() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a Librarian or a Member?");
        String userType = scanner.nextLine().toLowerCase();

        User user;
        if (userType.equals("librarian")) {
            user = new Librarian();
        } else if (userType.equals("member")) {
            user = new Member();
        } else {
            System.out.println("Invalid user type.");
            return;
        }

        user.useType();
    }
}

