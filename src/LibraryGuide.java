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

    // Using getters to retrieve information about the library guide

    /**
     * Retrieves the name of the library guide.
     *
     * @return The name of the library guide.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the email of the library guide.
     *
     * @return The email of the library guide.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the employee ID of the library guide.
     *
     * @return The employee ID of the library guide.
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Retrieves the phone number of the library guide.
     *
     * @return The phone number of the library guide.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Method that implements both the selectRandomBook and search method

    /**
     * Initiates the guidance system for library users.
     */
    public void Guide() {
        int i = 1;
        //LibrarySystem book = new LibrarySystem();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (i == 1) {
            System.out.println("Would you like a random book or search for a book");
            String choice2 = scanner.nextLine().toLowerCase();
            if (choice2.equals("random")) {
                selectRandomBook();
                i++;
            } else if (choice2.equals("search")) {
                search();
                i++;
            } else {
                System.out.println("Try Again");
            }
        }
    }

    // Method to randomly select a book

    /**
     * Selects a random book and displays its information.
     */
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
        System.out.println("Have a nice day!");
    }

    // Method to search for a book based on either the genre or page count

    /**
     * Searches for a book based on user input.
     */
    public static void search() {
        Book book = new Book();
        int i = 1;
        Scanner input = new Scanner(System.in);
        while (i == 1) {
            System.out.println("Would you like to search for a book by pages or genre?");
            String pG = input.nextLine();
            boolean available = false;
                if (pG.equals("pages")) { // Search by pages
                    System.out.println("Enter the maximum page count you want to search for:");
                    int maxPages = input.nextInt();
                    input.nextLine(); // Consume newline character
                    System.out.println("Books with page count less than " + maxPages + ":");
                    for (int k = 0; k < book.books.length; k++) {
                        int pageCount = Integer.parseInt(book.books[k][1]); // Accessing as an int
                        if (pageCount < maxPages) {
                            System.out.println(book.books[k][0] + " - " + pageCount + " pages, " + book.books[k][2]);
                            available = true;
                        }
                    }
                    if (!available) {
                        System.out.println("There are no books with less than " + maxPages + " pages.");
                    }
                    break;

                }
                        else if (pG.equals("genre")) { // Search by genre
                    i++;
                    // Get list of available genres
                    ArrayList<String> allGenres = new ArrayList<>();
                    for (int k = 0; k < book.books.length; k++) {
                        String genre = book.books[k][2];
                        if (!allGenres.contains(genre)) {
                            allGenres.add(genre);
                        }
                    }

                    // Prompt user to select a genre
                    System.out.println("Available genres:");
                    for (int x = 0; x < allGenres.size(); x++) {
                        System.out.println((x + 1) + ". " + allGenres.get(x));
                    }
                    System.out.println("Enter the number with the book you want:");
                    int selectedGenreIndex = input.nextInt();
                    input.nextLine();

                    // Display books with the selected genre
                    String selectedGenre = allGenres.get(selectedGenreIndex - 1);
                    System.out.println("Books in the genre \"" + selectedGenre + "\":");
                    for (int k = 0; k < book.books.length; k++) {
                        if (book.books[k][2].equals(selectedGenre)) {
                            System.out.println(book.books[k][0] + " - " + book.books[k][1] + " pages");
                        }
                    }
                } else {
                    System.out.println("Try Again");
                }

            }
        }
    }
