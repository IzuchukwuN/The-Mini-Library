import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String query;
    private static Object object;

    public static void main(String[] args) {
        LibrarySystem.libraryCardCreation();
        LibrarySystem library = new LibrarySystem();
        LibraryGuide guide = new LibraryGuide();
        Book book = new Book();
        //List<String[]> searchQuery = guide.searchQuery(String query, Book book);



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

    private static <searchQuery> List<String[]> getFiction(LibraryGuide guide, Book book) {
        return guide.searchQuery("Fiction", book);
        //print search results
        String[][] searchResults = new String[0][];
        if (searchResults.isEmpty()) {
            System.out.println("No matching books found.");
        } else {
            System.out.println("Matching books:");
            for (String[] bookInfo : searchResults) {
                System.out.println("Title: " + bookInfo[0] + ", Pages: " + bookInfo[1] + ", Genre: " + bookInfo[2]);
            }
        }
    }
}