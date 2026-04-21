import java.util.*; 
import java.lang.*; 
import java.io.*; 
class library{ 
    String book; 
    int edition; 
    double price; 
    library(){ 
    } 
    public library(String book, int edition, double price){ 
        this.book=book; 
        this.edition=edition; 
        this.price=price; 
    } 
    void displaydetails(){ 
        System.out.println("Book Details"); 
        System.out.println("Book name: "+book); 
        System.out.println("Edition : "+edition); 
        System.out.println("Price: ₹"+price); 
    } 
} 
class librarymanagement{ 
    public static void main (String[] args) throws java.lang.Exception { 
        Scanner s=new Scanner(System.in); 
        library a=new library(); 
        System.out.println("Enter the book details"); 
        System.out.println("Enter the book name"); 
        a.book=s.nextLine(); 
        System.out.println("Enter the edition"); 
        a.edition=s.nextInt(); 
        System.out.println("Enter the price"); 
        a.price=s.nextDouble(); 
        a.displaydetails();
    } 
} 