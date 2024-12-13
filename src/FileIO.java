import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
     * The FileIO class provides file operations and book management functionalities.
     */
    public class FileIO implements Serializable, bookoperations {
    private static final long serialVersionUID = 1L;

        // Class-level variables for managing books
        private Set<String> isbnSet = new HashSet<>();
        private Map<String, abstractBook> searchByISBN = new HashMap<>();
        private Map<String, abstractBook> searchByTitle = new HashMap<>();

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
                searchByISBN = (Map<String, abstractBook>) ois.readObject(); // Deserialize books by ISBN
                isbnSet = new HashSet<>(searchByISBN.keySet()); // Update ISBN set
                searchByTitle.clear(); // Rebuild searchByTitle map
                for (abstractBook book : searchByISBN.values()) {
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
        public boolean addBook(abstractBook book) {
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

        // Method to search for a book by ISBN
        public abstractBook searchByISBN(String isbn) {
            return searchByISBN.get(isbn);
        }

        // Method to search for a book by title
        public abstractBook searchByTitle(String title) {
            return searchByTitle.get(title.toLowerCase());
        }

        // Method to remove a book by ISBN
        public void removeBook(String isbn) {
            abstractBook removedBook = searchByISBN.remove(isbn);
            if (removedBook != null) {
                isbnSet.remove(isbn);
                searchByTitle.remove(removedBook.getTitle().toLowerCase());
                System.out.println("Book removed: " + removedBook.getTitle());
            } else {
                System.out.println("No book found with ISBN: " + isbn);
            }
        }

        // Method to display all books
        public void displayAllBooks() {
            if (searchByISBN.isEmpty()) {
                System.out.println("No books in the library.");
            } else {
                System.out.println("Books in the library:");
                for (abstractBook book : searchByISBN.values()) {
                    book.displayBookInfo();
                }
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
    abstract class AbstractBook1 implements Serializable {
        private static final long serialVersionUID = 1L;
        private String title;
        private String isbn;
        private String genre;

        public AbstractBook1 (String title, String isbn, String genre) {
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
    }

    /**
     * FictionBook class, a subclass of AbstractBook.
     */
    class fictionBook extends abstractBook {
        public fictionBook(String title, String isbn, String genre) {
            super(title, isbn, genre);
        }

        @Override
        public void displayBookInfo() {
            System.out.println("Fiction Book - Title: " + getTitle() + ", ISBN: " + getISBN() + ", Genre: ");
        }
    }

    /**
     * NonFictionBook class, a subclass of AbstractBook.
     */
    class nonfictionbook extends abstractBook {
        public nonfictionbook(String title, String isbn, String genre) {
            super(title, isbn, genre);
        }

        @Override
        public void displayBookInfo() {
            System.out.println("Non-Fiction Book - Title: " + getTitle() + ", ISBN: " + getISBN() + ", Genre: " );
        }
    }

    /**
     * Interface for book operations.
     */
    interface BookOperationsMalobi {
        void borrowBook();
        void returnBook();
    }


