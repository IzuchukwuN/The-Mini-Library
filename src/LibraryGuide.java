public class LibraryGuide extends LibrarySystem {
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

    public void Guide(){
        int i = 1;
        LibrarySystem book = new LibrarySystem();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while(i == 1) {
            System.out.println("Would you like a random book or search for a book");
            String choice2 = scanner.nextLine().toLowerCase();
            if (choice2.equals("random")) {
                selectRandomBook();
                i++;
            }
            else if(choice2.equals("search")){
                search();
                i++;
            }
            else{
                System.out.println("Try Again");
            }
        }
    }

    // Method to randomly select a book
    public void selectRandomBook() {
        // Create an instance of the Book class
        Book book = new Book();
        // Generate a random index between 0 and the length of the books array
        int randomIndex = (int) (Math.random() * book.books.length);
        // Print the book at the random index
        String[] selectedBook = book.books[randomIndex];

        System.out.println("Randomly selected book:");
        System.out.println("Title: " + selectedBook[0]);
        System.out.println("Pages: " + selectedBook[1]);
        System.out.println("Genre: " + selectedBook[2]);
    }

    public static void search(){
        int i = 1;
        int j = 0;
        java.util.Scanner input = new java.util.Scanner(System.in);
        while (i == 1) {
            System.out.println("Would you like to search for a book by pages or genre?");
            String pG = input.nextLine();
            if (pG.equals("pages")) {
                j = 1;
                i++;
            } else if (pG.equals("genre")) {
                j = 2;
                i++;
            } else {
                System.out.println("Try Again");
            }
        }
    }
}
