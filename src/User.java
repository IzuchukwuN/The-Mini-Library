abstract class User {

    public abstract void useType();
}

class Librarian extends User {
    @Override
    public void useType() {
        System.out.println("Librarian: Manages Books");
    }
}

class Member extends User {
    @Override
    public void useType() {
        System.out.println("Member: Borrowing and Searching for Books.");
    }
}