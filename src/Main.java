
import java.util.List;

public class Main {


    public static void main(String[] args) {
        LibrarySystem.libraryCardCreation();
        LibrarySystem library = new LibrarySystem();


        // Set username and password using setters
        library.setUsername("user123");
        library.setPassword("password123");

        // Retrieve username and password using getters
        System.out.println("Username: " + library.getUsername());
        System.out.println("Password: " + library.getPassword());
        // Calls the cardNum method using the library object
        System.out.println(library.cardNum());

        LibraryGuide guide = new LibraryGuide("User User", "user.user@example.com", "123456", "+12345678900");

        System.out.println("Name: " + guide.getName());
        System.out.println("Email: " + guide.getEmail());
        System.out.println("Employee ID: " + guide.getEmployeeId());
        System.out.println("Phone Number: " + guide.getPhoneNumber());
    }
}


