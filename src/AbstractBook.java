/**
 * AbstractBook is an abstract class that defines shared functionality for all book types.
 */
public abstract class AbstractBook implements BookOperations {
    protected String title;
    protected String genre;
    private String isbn;
    private boolean isBorrowed;

    // Constructor for creating a Book object
    public AbstractBook(String title, String isbn, String genre) {
        this.title = title;
        this.genre = genre;
        this.isBorrowed = false; // default
        this.isbn = isbn;
    }

    // Abstract method to display book info
    public abstract void displayBookInfo();

    // Borrowing the book
    @Override
    public void borrowBook() {
        if (isBorrowed) {
            System.out.println("Book is already borrowed: " + title);
        } else {
            isBorrowed = true;
            System.out.println("Book borrowed: " + title);
        }
    }

    // Returning the book
    @Override
    public void returnBook() {
        if (!isBorrowed) {
            System.out.println("Book is not currently borrowed: " + title);
        } else {
            isBorrowed = false;
            System.out.println("Book returned: " + title);
        }
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
    public String getISBN() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }
}