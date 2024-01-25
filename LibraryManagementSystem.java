/*TASK 2

LIBRARY MANAGEMENT SYSTEM

● Create a Book class with attributes like title, author, and status (checked out or
available).
● Implement a LibraryCatalog class to manage books.
● Add methods to add books, search by title or author, check out, and return books.
● Use ArrayList to store and manage books. */
import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public void searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                return;
            }
        }
        System.out.println("Book not found with author: " + author);
    }

    public void displayAllBooks() {
        System.out.println("List of all books in the library:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() +
                    " - Status: " + (book.isCheckedOut() ? "Checked Out" : "Available"));
        }
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isCheckedOut()) {
                    book.setCheckedOut(true);
                    System.out.println("Book checked out successfully: " + book.getTitle());
                } else {
                    System.out.println("Book is already checked out: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isCheckedOut()) {
                    book.setCheckedOut(false);
                    System.out.println("Book returned successfully: " + book.getTitle());
                } else {
                    System.out.println("Book is already available: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();

        // Adding books to the library
        library.addBook(new Book("The Hidden Hindu", "Akash Gupta"));
        library.addBook(new Book("Think Like a Monk", "Jay Shetty"));
        library.addBook(new Book("Ikigai: The Japanese Secret to a Long and Happy Life", "Francesc Miralles and Hector Garcia"));

        // Searching for books
        library.searchByTitle("Think Like a Monk");
        library.searchByAuthor("Jay Shetty");

        // Displaying all books
        library.displayAllBooks();

        // Checking out and returning books
        library.checkOutBook("Think Like a Monk");
        library.returnBook("Think Like a Monk");
    }
}