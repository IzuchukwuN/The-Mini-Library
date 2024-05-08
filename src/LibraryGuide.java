
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Boolean;

public class LibraryGuide extends LibrarySystem {
    public static class LibraryGuide implements Book {
        // Private variables to store information about a library guide
        private String name;
        private String email;
        private String employeeId;
        private String phoneNumber;
        int pages = 100,500;


        // Constructor to initialize the LibraryGuide object with provided values
        public LibraryGuide(String name, String email, String employeeId, String phoneNumber) {
            this.name = name;
            this.email = email;
            this.employeeId = employeeId;
            this.phoneNumber = phoneNumber;
        }

        public LibraryGuide() {

        }

        // Using getters to retrieve information about the library guide

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        // Method to randomly select a book
        public void selectRandomBook() {

            // Create an instance of the Book class
            Book book = new Book();

            // Generate a random index between 0 and the length of the books array
            int randomIndex = (int) (Math.random() * book.books.length);

            // Print the book at the random index
            String[] selectedBook = book.books[randomIndex];

            System.out.println("Randomly selected book:");
            System.out.println("Title: " + selectedBook[0]);
            System.out.println("Pages: " + selectedBook[1]);
            System.out.println("Genre: " + selectedBook[2]);
        }

        public static List search() {
            System.out.println("Would you like to search for a book by name, pages, or genre?");
            //search by amount of pages using operators

            if (int i = 0; i <=100; i++) {
                System.out.println("Enter number of pages" + i++);
                i++;
                return;
            } else if (int i =0; i >=500; ++i) {
                System.out.println("Enter number of pages" + ++i);}

        }
    }
}

