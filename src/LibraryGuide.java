
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
}