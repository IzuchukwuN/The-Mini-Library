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
        }
    }