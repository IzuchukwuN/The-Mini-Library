import java.util.ArrayList;
import java.util.List;
public class LibraryGuide {
    // Private variables to store information about a library guide
    private String name;
    private String email;
    private String employeeId;
    private String phoneNumber;

    // Constructor to initialize the LibraryGuide object with provided values
    public LibraryGuide(String name, String email, String employeeId, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
    }

    public LibraryGuide() {

    }

    // Using getters to retrieve information about the library guide

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;

    }

    // Method to search for books based on title, genre, or page number
    public List<String[]> searchQuery(String query, Book book) {
        List<String[]> results = new ArrayList<>();

        // Iterate through the books array and check for matches
        for (String[] bookInfo : book.books) {
            if (bookInfo[0].toLowerCase().contains(query.toLowerCase()) ||  // Title match
                    bookInfo[1].equalsIgnoreCase(query) ||                     // Page number match
                    bookInfo[2].equalsIgnoreCase(query)) {                    // Genre match
                results.add(bookInfo);
            }
        }

        return results;
    }
}
