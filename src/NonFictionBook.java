class NonFictionBook extends AbstractBook {
    public NonFictionBook(String title, String isbn, String genre) {
        super(title, isbn, genre);
    }

    @Override
    public void displayBookInfo() {
        System.out.println("Non-Fiction Book: " + title + ", isbn: " + getISBN() + ", Genre: " + genre);
    }
}
