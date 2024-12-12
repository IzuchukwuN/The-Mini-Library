import java.util.*;

class LibrarySystem {
    //Set that keeps track of a book's isbn
    private Set<String> isbnSet;
    //Map that searches for a book by isbn
    private Map<String, AbstractBook> searchByISBN;
    //Map that searches for a book by title
    private Map<String, AbstractBook> searchByTitle;

    //Constructor that initializes all the data structures
    public LibrarySystem() {
        isbnSet = new HashSet<>();
        searchByISBN = new HashMap<>();
        searchByTitle = new HashMap<>();
    }

    //Method to add a book to the library
    public boolean addBook(AbstractBook book) {
        //Checks for the isbn in the system
        if (isbnSet.contains(book.getISBN())) {
            System.out.println("This ISBN is a duplicate: " + book.getISBN());
            return false;
        }
        //Stores the book in lower case to avoid case sensitive searches
        isbnSet.add(book.getISBN());
        searchByISBN.put(book.getISBN(), book);
        searchByTitle.put(book.getTitle().toLowerCase(), book);
        System.out.println("Book added: " + book.getTitle());
        return true;
    }

    //Method that removes a book from the system by its isbn
    public boolean removeBook(String isbn) {
        AbstractBook book = searchByISBN.remove(isbn);
        if (book != null) {
            searchByTitle.remove(book.getTitle().toLowerCase());
            isbnSet.remove(isbn);
            System.out.println("Book removed: " + book.getTitle());
            return true;
        }
        System.out.println("Book not found: " + isbn);
        return false;
    }

    //Method that searches for a book by its isbn
    public AbstractBook searchByISBN(String isbn) {
        return searchByISBN.get(isbn);
    }

    //Searches for a book by its isbn
    public AbstractBook searchByTitle(String title) {
        return searchByTitle.get(title.toLowerCase());
    }

    //Displays all the books in the library system
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
    }
