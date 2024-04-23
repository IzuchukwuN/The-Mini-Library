public class  LibrarySystem {
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

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Set username and password using setters
        library.setUsername("user123");
        library.setPassword("password123");

        // Retrieve username and password using getters
        System.out.println("Username: " + library.getUsername());
        System.out.println("Password: " + library.getPassword());
    }
}
