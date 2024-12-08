/**
 * The Main class contains the main method to run the entire library system.
 */
import java.util.*;

public class Main {

    private static LibrarySystem librarySystem = new LibrarySystem();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        AbstractBook book1 = new FictionBook("The Catcher in the Rye", "232342", "Fiction");
        AbstractBook book2 = new NonFictionBook("Sapiens: A Brief History of Humankind", "432523", "Non-fiction");

        librarySystem.addBook(book1);
        librarySystem.addBook(book2);



        removeByISBN();
        librarySystem.displayAllBooks();
    }

    public static void searchISBN(){
        System.out.println("Enter the isbn you want to search for: ");
        String isbn = input.nextLine();
        AbstractBook found1 = librarySystem.searchByISBN(isbn);
        if (found1 != null) {
            found1.displayBookInfo();
        }
        else {
            System.out.println("Book not found by ISBN.");
        }
    }
    public static void removeByISBN(){
        System.out.println("Enter the isbn you wish to remove: ");
        String isbn = input.nextLine();
        librarySystem.removeBook(isbn);
    }
    public static void searchTitle(){
        System.out.println("Enter the title you want to search for: ");
        String title = input.nextLine();
        AbstractBook found1 = librarySystem.searchByTitle(title);
        if (found1 != null) {
            found1.displayBookInfo();
        } else {
            System.out.println("Book not found by Title.");
        }
    }
}

