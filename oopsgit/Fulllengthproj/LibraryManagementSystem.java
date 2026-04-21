import java.util.*; 
class Book { 
private int bookId; 
    private String title; 
    private String author; 
    private boolean isAvailable; 
 
    public Book(int bookId, String title, String author) { 
        this.bookId = bookId; 
        this.title = title; 
        this.author = author; 
        this.isAvailable = true; 
    } 
 
    public int getBookId() { 
        return bookId; 
    } 
 
    public String getTitle() { 
        return title; 
    } 
 
    public String getAuthor() { 
        return author; 
    } 
 
    public boolean isAvailable() { 
        return isAvailable; 
    } 
 
    public void setAvailability(boolean status) { 
        this.isAvailable = status; 
    } 
 
    public String toString() { 
        return bookId + " | " + title + " | " + author + " | " + 
               (isAvailable ? "Available" : "Borrowed"); 
    } 
} 
 
 
class User { 
    private String name; 
    private List<Book> borrowedBooks; 
 
    public User(String name) { 
        this.name = name; 
        borrowedBooks = new ArrayList<>(); 
    } 
 
    public void borrowBook(Book book) { 
        borrowedBooks.add(book); 
    } 
 
    public void returnBook(Book book) { 
        borrowedBooks.remove(book); 
    } 
 
    public void showBorrowedBooks() { 
        if (borrowedBooks.isEmpty()) { 
            System.out.println("No books borrowed."); 
        } else { 
            for (Book b : borrowedBooks) { 
                System.out.println(b); 
            } 
        } 
    } 
} 
 
 
class Library { 
    private List<Book> books; 
 
    public Library() { 
        books = new ArrayList<>(); 
    } 
 
    public void addBook(int id, String title, String author) { 
        books.add(new Book(id, title, author)); 
    } 
 
    public void displayBooks() { 
        if (books.isEmpty()) { 
            System.out.println("No books in library."); 
            return; 
        } 
 
        System.out.println("\n Library Books:"); 
        for (Book b : books) { 
            System.out.println(b); 
        } 
    } 
 
    public Book findBook(int id) { 
        for (Book b : books) { 
            if (b.getBookId() == id) { 
                return b; 
            } 
        } 
        return null; 
    } 
 
    public void borrowBook(User user, int id) { 
        Book b = findBook(id); 
 
        if (b == null) { 
            System.out.println("Book not found!"); 
        } else if (!b.isAvailable()) { 
            System.out.println("Book already borrowed!"); 
        } else { 
            b.setAvailability(false); 
            user.borrowBook(b); 
            System.out.println("Book borrowed successfully!"); 
        } 
    } 
 
    public void returnBook(User user, int id) { 
        Book b = findBook(id); 
 
        if (b == null) { 
            System.out.println("Book not found!"); 
        } else { 
            b.setAvailability(true); 
            user.returnBook(b); 
            System.out.println("Book returned successfully!"); 
        } 
    } 
} 
 
 
public class LibraryManagementSystem { 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
        Library library = new Library(); 
 
        System.out.println("Enter number of books to add: "); 
        int n = sc.nextInt(); 
        sc.nextLine(); 
 
        for (int i = 0; i < n; i++) { 
            System.out.println("\nEnter details for Book " + (i + 1)); 
 
            System.out.println("Book ID: "); 
            int id = sc.nextInt(); 
            sc.nextLine(); 
 
            System.out.println("Title: "); 
            String title = sc.nextLine(); 
 
            System.out.println("Author: "); 
            String author = sc.nextLine(); 
 
            library.addBook(id, title, author); 
        } 
 
        System.out.println("\nEnter your name: "); 
        String name = sc.nextLine(); 
        User user = new User(name); 
 
        int choice; 
 
        do { 
            System.out.println("\n====== LIBRARY MENU ======"); 
            System.out.println("1. View Books"); 
            System.out.println("2. Borrow Book"); 
            System.out.println("3. Return Book"); 
            System.out.println("4. View My Books"); 
            System.out.println("5. Exit"); 
 
            System.out.println("Enter choice: "); 
            choice = sc.nextInt(); 
 
            switch (choice) { 
                case 1: 
                    library.displayBooks(); 
                    break; 
 
                case 2: 
                    System.out.println("Enter Book ID: "); 
                    int borrowId = sc.nextInt(); 
                    library.borrowBook(user, borrowId); 
                    break; 
 
                case 3: 
                    System.out.println("Enter Book ID: "); 
                    int returnId = sc.nextInt(); 
                    library.returnBook(user, returnId); 
                    break; 
 
                case 4: 
                    System.out.println("\nYour Borrowed Books:"); 
                    user.showBorrowedBooks(); 
                    break; 
 
                case 5: 
                    System.out.println("Exiting..."); 
                    break; 
 
                default: 
                    System.out.println("Invalid choice!"); 
            } 
 
        } while (choice != 5); 
 
        sc.close(); 
    } 
} 