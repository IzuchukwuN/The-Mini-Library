/**
 * The Book class stores information about various books.
 */

public abstract class AbstractBook implements BookOperations  {

    protected String title;
    protected int pages;
    protected String genre;
    private boolean isBorrowed;
    
    // Constructor for creating a Book object
    public AbstractBook(String title, int pages, String genre) {
        this.title = title;
        this.pages = pages;
        this.genre = genre;
        this.isBorrowed = false; // default
    }

    public abstract void dislayBookInfo ();
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
    } 
  
