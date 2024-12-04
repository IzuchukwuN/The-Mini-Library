/**
 * The Main class contains the main method to run the entire library system.
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello");
        System.out.println("Create an account to get started.");

        // Create a user account
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = new User(username, password);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. View all books");
            System.out.println("2. Search by title");
            System.out.println("3. Search by genre");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. View borrowed books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // View all books
                    library.displayAllBooks();
                    break;

                case 2: // Search by title
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    library.searchByTitle(title);
                    break;

                case 3: // Search by genre
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    library.searchByGenre(genre);
                    break;

                case 4: // Borrow a book
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    for (Book book : Book.books) {
                        if (book.title.equalsIgnoreCase(borrowTitle)) {
                            user.borrowBook(book);
                            break;
                        }
                    }
                    break;

                case 5: // Return a book
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    for (Book book : Book.books) {
                        if (book.title.equalsIgnoreCase(returnTitle)) {
                            user.returnBook(book);
                            break;
                        }
                    }
                    break;

                case 6: // View borrowed books
                    user.displayBorrowedBooks();
                    break;

                case 7: // Exit
                    System.out.println("Thank you for using the Library System!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
