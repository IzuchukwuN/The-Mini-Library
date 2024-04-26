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

    // Method that creates a random 9-digit number
    public int cardNum(){
        System.out.print("Your library card number is: ");
        return (int)(Math.random()*(Integer.MAX_VALUE-1000000000))+1000000000;
    }
}
