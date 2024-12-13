import java.util.*;

/**
 * The Main class contains the main method to run the entire library system.
 */
public class Main {
    private static LibrarySystem librarySystem = new LibrarySystem();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the library system, below are a variety of options to choose from.");
        boolean isWorking = true;

        //Loop that repeats the list for the user
        while (isWorking) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Search for a book by ISBN");
            System.out.println("3. Search for a book by Title");
            System.out.println("4. Display all books");
            System.out.println("5. Remove a book by ISBN");
            System.out.println("6. Borrow a book by ISBN");
            System.out.println("7. Return a book by ISBN");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            try {
                int choice = input.nextInt();
                input.nextLine(); // Consume the newline character

                if (choice == 1) {
                    addBook();
                }
                else if (choice == 2) {
                    searchBookByISBN();
                }
                else if (choice == 3) {
                    searchBookByTitle();
                }
                else if (choice == 4) {
                    librarySystem.displayAllBooks();
                }
                else if (choice == 5) {
                    removeBookByISBN();
                }
                else if(choice == 6){
                    borrowBook();
                }
                else if(choice == 7){
                    returnBook();
                }
                else if (choice == 8) {
                    isWorking = false;
                    System.out.println("Exiting the library system. Goodbye!");
                }
                else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            //Catches improper numeric inputs
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // Clear the invalid input
            }
            //Catches any other improper inputs
            catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    //Method to add a book into the system
    public static void addBook() {
        try {
            System.out.print("Enter the title of the book: ");
            String title = input.nextLine();
            System.out.print("Enter the ISBN of the book: ");
            String isbn = input.nextLine();
            System.out.print("Enter either Fiction or Non-fiction: ");
            String genre = input.nextLine();

            //Creates a book based on the type of book it is
            AbstractBook book;
            if (genre.equalsIgnoreCase("Fiction")) {
                book = new FictionBook(title, isbn, genre);
            } else if (genre.equalsIgnoreCase("Non-fiction")) {
                book = new NonFictionBook(title, isbn, genre);
            } else {
                System.out.println("Invalid genre. Book not added.");
                return;
            }

            //Adds book to the system
            librarySystem.addBook(book);
        } catch (Exception e) {
            System.out.println("An error occurred while adding the book: " + e.getMessage());
        }
    }

    //Method to search for a book by its isbn
    public static void searchBookByISBN() {
        try {
            System.out.print("Enter the ISBN of the book to search: ");
            String isbn = input.nextLine();
            AbstractBook book = librarySystem.searchByISBN(isbn);
            if (book != null) {
                System.out.println("Book found:");
                book.displayBookInfo();
            } else {
                System.out.println("Book with ISBN \"" + isbn + "\" not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while searching by ISBN: " + e.getMessage());
        }
    }

    //Method to search for a book by its title
    public static void searchBookByTitle() {
        try {
            System.out.print("Enter the title of the book to search: ");
            String title = input.nextLine();
            AbstractBook book = librarySystem.searchByTitle(title);
            if (book != null) {
                System.out.println("Book found:");
                book.displayBookInfo();
            } else {
                System.out.println("Book with title \"" + title + "\" not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while searching by title: " + e.getMessage());
        }
    }

    //Method to remove a book by its isbn
    public static void removeBookByISBN() {
        try {
            System.out.print("Enter the ISBN of the book to remove: ");
            String isbn = input.nextLine();
            librarySystem.removeBook(isbn);
        } catch (Exception e) {
            System.out.println("An error occurred while removing the book: " + e.getMessage());
        }
    }

    //Method to borrow a book from the library
    public static void borrowBook() {
        try {
            System.out.print("Enter the ISBN of the book you want to borrow: ");
            String isbn = input.nextLine();
            AbstractBook book = librarySystem.searchByISBN(isbn);
            if (book != null) {
                book.borrowBook();
            } else {
                System.out.println("Book with ISBN \"" + isbn + "\" not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while borrowing the book: " + e.getMessage());
        }
    }

    //Method to return a book to the library
    public static void returnBook() {
        try {
            System.out.print("Enter the ISBN of the book you want to return: ");
            String isbn = input.nextLine();
            AbstractBook book = librarySystem.searchByISBN(isbn);
            if (book != null) {
                book.returnBook();
            } else {
                System.out.println("Book with ISBN \"" + isbn + "\" not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while returning the book: " + e.getMessage());
        }
    }
}
