import java.util.*;

// Generic class to manage books or any subclass of AbstractBook
public class LibrarySystem<T extends AbstractBook> {

    // Set to track unique ISBNs
    private Set<String> isbnSet;

    // Map to search for books by ISBN
    private Map<String, T> searchByISBN;

    // Map to search for books by title
    private Map<String, T> searchByTitle;

    // Constructor to initialize the data structures
    public LibrarySystem() {
        isbnSet = new HashSet<>();
        searchByISBN = new HashMap<>();
        searchByTitle = new HashMap<>();
    }

    // Method to add a book to the library
    public boolean addBook(T book) {
        if (isbnSet.contains(book.getISBN())) {
            System.out.println("This ISBN is already in the system: " + book.getISBN());
            return false;
        }
        // Add the book details
        isbnSet.add(book.getISBN());
        searchByISBN.put(book.getISBN(), book);
        searchByTitle.put(book.getTitle().toLowerCase(), book);
        System.out.println("Book added: " + book.getTitle());
        return true;
    }

    // Method to remove a book by its ISBN
    public boolean removeBook(String isbn) {
        T book = searchByISBN.remove(isbn);
        if (book != null) {
            searchByTitle.remove(book.getTitle().toLowerCase());
            isbnSet.remove(isbn);
            System.out.println("Book removed: " + book.getTitle());
            return true;
        }
        System.out.println("Book not found with ISBN: " + isbn);
        return false;
    }

    // Method to search for a book by its ISBN
    public T searchByISBN(String isbn) {
        return searchByISBN.get(isbn);
    }

    // Method to search for a book by its title
    public T searchByTitle(String title) {
        return searchByTitle.get(title.toLowerCase());
    }

    // Displays all books 
    public void displayAllBooks() {
        if (searchByISBN.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Books in the library:");
        List<T> books = new ArrayList<>(searchByISBN.values());
        displayBooksRecursively(books, 0); // Starts the recursive display
    }

    // Recursive helper method to display books
    private void displayBooksRecursively(List<T> books, int index) {
        if (index >= books.size()) {
            return; // Base case: end of the list
        }
        books.get(index).displayBookInfo(); // Display current book
        displayBooksRecursively(books, index + 1); // Recursive call for the next book
    }
}
