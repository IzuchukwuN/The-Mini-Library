import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.*;
public class ListStacksQueues {

    // List for storing books
    private List<AbstractBook> bookList;

    // Stack for undo operations (e.g., undo book removal)
    private Stack<AbstractBook> undoStack;

    // Queue for managing book requests
    private Queue<BookRequest> bookRequestQueue;

    {
        bookList = new ArrayList<>();
        undoStack = new Stack<>();
        bookRequestQueue = new LinkedList<>();
    }

    // Add a book to the list
    public void addBook(AbstractBook book) {
        bookList.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Search for a book by ISBN
    public AbstractBook searchByISBN(String isbn) {
        for (AbstractBook book : bookList) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Search for a book by Title
    public AbstractBook searchByTitle(String title) {
        for (AbstractBook book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Remove a book by ISBN and push it to the undo stack
    public void removeBook(String isbn) {
        for (AbstractBook book : bookList) {
            if (book.getISBN().equals(isbn)) {
                bookList.remove(book);
                undoStack.push(book); // Push removed book onto the stack
                System.out.println("Book removed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found: " + isbn);
    }

    // Undo the last book removal
    public void undoLastRemoval() {
        if (!undoStack.isEmpty()) {
            AbstractBook book = undoStack.pop(); // Pop the last removed book
            bookList.add(book); // Re-add it to the list
            System.out.println("Undo successful: Book re-added: " + book.getTitle());
        } else {
            System.out.println("No actions to undo.");
        }
    }

    // Add a book request to the queue
    public void requestBook(String isbn, String requesterName) {
        bookRequestQueue.add(new BookRequest(isbn, requesterName));
        System.out.println("Book request added for ISBN: " + isbn + " by " + requesterName);
    }

    // Process book requests from the queue
    public void processBookRequests() {
        while (!bookRequestQueue.isEmpty()) {
            BookRequest request = bookRequestQueue.poll(); // Process next request
            System.out.println("Processing request for ISBN: " + request.getIsbn() + " by " + request.getRequesterName());
        }
    }

    // Display all books
    public void displayAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (AbstractBook book : bookList) {
                book.displayBookInfo();
            }
        }
    }
}
