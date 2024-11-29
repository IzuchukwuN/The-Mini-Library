public class FictionBook extends Book {
        public FictionBook(String title, int pages, String genre) {
            super(title, pages, genre);
        }

        @Override
        public void displayBookInfo() {
            System.out.println("Fiction Book: " + title + ", " + pages + " pages, Genre: " + genre);
        }
    }
