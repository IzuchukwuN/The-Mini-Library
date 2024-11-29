class NonFictionBook extends Book {
    public NonFictionBook(String title, int pages, String genre) {
        super(title, pages, genre);
    }

    @Override
    public void displayBookInfo() {
        System.out.println("Non-Fiction Book: " + title + ", " + pages + " pages, Genre: " + genre);
    }
}