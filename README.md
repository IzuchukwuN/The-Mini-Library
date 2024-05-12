# mini-library-group-project
# Team Member Names: Bruno Nwadike, Rosaire, Abraham Getachew, Nimra Ejaz
# Problem: We are creating a mini library system that can find any book within the library and output it to the user. It will take a series of different values in order to pinpoint the book that is wanted. Users will have to create an account and check out the books they want to borrow.
# UML Diagram: class Main {
  # +main(String[] args)
# }

# class LibrarySystem {
  # -username: String
  # -password: String
  # +getUsername(): String
  # +setUsername(String): void
  # +getPassword(): String
  # +setPassword(String): void
  # +cardNum(): int
  # +libraryCardCreation(): void
# }

# class LibraryGuide {
 # -name: String
 # -email: String
  # -employeeId: String
 # -phoneNumber: String
# +getName(): String
  # +getEmail(): String
  # +getEmployeeId(): String
  # +getPhoneNumber(): String
  # +LibraryGuide(String, String, String, String)
  # +Guide(): void
  # +selectRandomBook(): void
  # +search(): void
# }

# class Book {
  # -books: String[][]
# }
