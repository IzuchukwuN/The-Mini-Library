public class Main {
    public static void main(String[] args){
        LibrarySystem library = new LibrarySystem();

        // Set username and password using setters
        library.setUsername("user123");
        library.setPassword("password123");

        // Retrieve username and password using getters
        System.out.println("Username: " + library.getUsername());
        System.out.println("Password: " + library.getPassword());
        System.out.println(library.cardNum());
    }
}
