import java.util.*;

public class LibrarySystem {
    private Set<String> isbnSet;
    private Map<String, AbstractBook> searchByISBN;
    private Map<String, AbstractBook> searchByTitle;

    public LibrarySystem() {
        isbnSet = new HashSet<>();
        searchByISBN = new HashMap<>();
        searchByTitle = new HashMap<>();
    }

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

    public AbstractBook searchByISBN(String isbn) {
        return searchByISBN.get(isbn);
    }

    public AbstractBook searchByTitle(String title) {
        return searchByTitle.get(title.toLowerCase());
    }

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

