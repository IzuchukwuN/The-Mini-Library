import java.io.Serializable;
import java.util.*;

public class DataStructuresLibrary implements Serializable, bookoperations{
    private static final long serialVersionUID = 1L;
    // Data structures for managing books
    private List<abstractBook> bookList = new ArrayList<>();
    private Stack<abstractBook> undoStack = new Stack<>();
    private Queue<String> requestQueue = new LinkedList<>();

    // Method to add a book to the library
    public boolean addBook(abstractBook book) {
        for (abstractBook b : bookList) {
            if (b.getISBN().equals(book.getISBN())) {
                System.out.println("This ISBN is a duplicate: " + book.getISBN());
                return false;
            }
        }
        bookList.add(book);
        undoStack.push(book); // Log the addition for undo
        System.out.println("Book added: " + book.getTitle());
        return true;
    }

    // Method to remove a book by ISBN
    public void removeBook(String isbn) {
        Iterator<abstractBook> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            abstractBook book = iterator.next();
            if (book.getISBN().equals(isbn)) {
                iterator.remove();
                undoStack.push(book); // Log the removal for undo
                System.out.println("Book removed: " + book.getTitle());
                return;
            }
        }
        System.out.println("No book found with ISBN: " + isbn);
    }

    // Method to search for a book by ISBN
    public abstractBook searchByISBN(String isbn) {
        for (abstractBook book : bookList) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Method to search for a book by title
    public abstractBook searchByTitle(String title) {
        for (abstractBook book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Method to display all books
    public void displayAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (abstractBook book : bookList) {
                book.displayBookInfo();
            }
        }
    }

    // Method to undo the last operation (add or remove)
    public void undoLastOperation() {
        if (undoStack.isEmpty()) {
            System.out.println("No operations to undo.");
            return;
        }
        abstractBook lastOperation = undoStack.pop();
        if (bookList.contains(lastOperation)) {
            bookList.remove(lastOperation);
            System.out.println("Undo: Removed book " + lastOperation.getTitle());
        } else {
            bookList.add(lastOperation);
            System.out.println("Undo: Re-added book " + lastOperation.getTitle());
        }
    }

    // Method to add a book request to the queue
    public void requestBook(String title) {
        requestQueue.add(title);
        System.out.println("Book request added: " + title);
    }

    // Method to process a book request from the queue
    public void processRequest() {
        if (requestQueue.isEmpty()) {
            System.out.println("No requests to process.");
        } else {
            String request = requestQueue.poll();
            System.out.println("Processing request for book: " + request);
        }
    }

    @Override
    public void borrowBook() {
        System.out.println("Borrow book functionality not implemented yet.");
    }

    @Override
    public void returnBook() {
        System.out.println("Return book functionality not implemented yet.");
    }
}

/**
 * AbstractBook class to represent a generic book.
 */
abstract class abstractBook implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String isbn;
    private String genre;

    public abstractBook(String title, String isbn, String genre) {
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public abstract void displayBookInfo();

    public void borrowBook() {
    }
}

/**
 * FictionalBook class, a subclass of AbstractBook.
 */
class FictionalBook extends abstractBook {
    public FictionalBook(String title, String isbn, String genre) {
        super(title, isbn, genre);
    }

    @Override
    public void displayBookInfo() {
        System.out.println("Fiction Book - Title: " + getTitle() + ", ISBN: " + getISBN() + ", Genre: " + getGenre());
    }
}

/**
 * NonFictionBook class, a subclass of AbstractBook.
 */
class NonFictionalBook extends abstractBook {
    public NonFictionalBook(String title, String isbn, String genre) {
        super(title, isbn, genre);
    }

    @Override
    public void displayBookInfo() {
        System.out.println("Non-Fiction Book - Title: " + getTitle() + ", ISBN: " + getISBN() + ", Genre: " + getGenre());
    }
}

/**
 * Interface for book operations.
 */
interface bookoperations {
    void borrowBook();

    void returnBook();
}

