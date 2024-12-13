import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.*;

abstract class AbstractBook1 implements Serializable, BookOperations {

    private static final long serialVersionUID = 1L;

    // Class-level variables for managing books
    private Set<String> isbnSet = new HashSet<>();
    private Map<String, AbstractBook> searchByISBN = new HashMap<>();
    private Map<String, AbstractBook> searchByTitle = new HashMap<>();

    // Method to save library data
    public void saveLibraryData(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(searchByISBN); // Serialize books by ISBN
            System.out.println("Library data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving library data: " + e.getMessage());
        }
    }

    // Method to load library data
    @SuppressWarnings("unchecked")
    public void loadLibraryData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            searchByISBN = (Map<String, AbstractBook>) ois.readObject(); // Deserialize books by ISBN
            isbnSet = searchByISBN.keySet(); // Update ISBN set
            searchByTitle.clear(); // Rebuild searchByTitle map
            for (AbstractBook book : searchByISBN.values()) {
                searchByTitle.put(book.getTitle().toLowerCase(), book);
            }
            System.out.println("Library data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading library data: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Data format error: " + e.getMessage());
        }
    }

    // Method to add a book to the library
    public boolean addBook(AbstractBook book) {
        if (isbnSet.contains(book.getISBN())) {
            System.out.println("This ISBN is a duplicate: " + book.getISBN());
            return false;
        }
        isbnSet.add(book.getISBN());
        searchByISBN.put(book.getISBN(), book);
        searchByTitle.put(book.getTitle().toLowerCase(), book);
        System.out.println("Book added: " + book.getTitle());
        return true;
    }

    // Method to display all books
    public void displayAllBooks() {
        if (searchByISBN.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (AbstractBook book : searchByISBN.values()) {
                book.displayBookInfo();
            }
        }
    }

    // Abstract method to be implemented by subclasses
    protected abstract void displayBookInfo();

    // Getters for subclasses
    public String getTitle() {
        return getTitle();
    }

    public String getISBN() {
        return getISBN();
    }


}
