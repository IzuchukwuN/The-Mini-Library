public class Book extends AbstractBook {
 
    public Book(String title, int pages, String genre){
        super(title, pages, genre); // Call the constructor of AbstractBook 
      }

   @Override
   public void displayBookInfo() {
        System.out.println("Book: " + title + ", " + pages + " pages, Genre: " + genre);
    }

  
    public static Book[] books = {
            new FictionBook("The Catcher in the Rye", 277, "Fiction"),
            new FictionBook("To Kill a Mockingbird", 324, "Fiction"),
            new FictionBook("The Great Gatsby", 180, "Fiction"),
            new FictionBook("The Alchemist", 197, "Fiction"),
            new FictionBook("The Road", 241, "Fiction"),
            new FictionBook("The Kite Runner", 371, "Fiction"),
            new FictionBook("Anna Karenina", 864, "Fiction"),
            new FictionBook("One Hundred Years of Solitude", 417, "Fiction"),
            new FictionBook("Crime and Punishment", 671, "Fiction"),
            new FictionBook("The Grapes of Wrath", 464, "Fiction"),
            new FictionBook("The Old Man and the Sea", 127, "Fiction"),
            new FictionBook("The Sun Also Rises", 251, "Fiction"),
            new FictionBook("The Bell Jar", 244, "Fiction"),
            new FictionBook("Middlemarch", 880, "Fiction"),
            new NonFictionBook("A Brief History of Time", 212, "Non-fiction"),
            new NonFictionBook("Sapiens: A Brief History of Humankind", 443, "Non-fiction"),
            new NonFictionBook("The Road Less Traveled", 316, "Non-fiction"),
            new NonFictionBook("The Road to Serfdom", 274, "Non-fiction")
    };
}
