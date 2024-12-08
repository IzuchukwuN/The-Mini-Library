public class FictionBook extends AbstractBook {
        public FictionBook(String title, String isbn, String genre) {
            super(title, isbn, genre);
        }

        @Override
        public void displayBookInfo() {
            System.out.println("Fiction Book: " + title + ", isbn: " + getISBN() + ", Genre: " + genre);
        }
    }
