import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        isAvailable = availability;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void displayBooks() {
        System.out.println("ID\tTitle\t\tAuthor\tAvailability");
        for (Book book : books) {
            System.out.println(
                    book.getId() + "\t" + book.getTitle() + "\t\t" + book.getAuthor() + "\t" + book.getAvailability());
        }
    }

    public boolean checkOut(int id) {
        Book book = searchBook(id);
        if (book != null && book.getAvailability()) {
            book.setAvailability(false);
            return true;
        }
        return false;
    }

    public boolean checkIn(int id) {
        Book book = searchBook(id);
        if (book != null && !book.getAvailability()) {
            book.setAvailability(true);
            return true;
        }
        return false;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book(101, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(102, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(103, "Pride and Prejudice", "Jane Austen"));
        library.displayBooks();
        System.out.println();

        int bookId = 102;
        System.out.println("Checking out book with ID: " + bookId);
        boolean checkOutSuccess = library.checkOut(bookId);
        System.out.println("Check out success: " + checkOutSuccess);
        System.out.println();

        System.out.println("Updated Book List");
        library.displayBooks();
        System.out.println();

        System.out.println("Checking in book with ID: " + bookId);
        boolean checkInSuccess = library.checkIn(bookId);
    }
}