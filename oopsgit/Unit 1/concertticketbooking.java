import java.util.*; 
import java.lang.*; 
import java.io.*; 
class concertticket{
    String tickettype; 
    double baseprice; 
    double finalprice; 
    int quantity; 
    concertticket(){ 
    } 
    concertticket(double price, int qty){ 
        this.baseprice=price; 
        this.quantity=qty; 
        this.finalprice=(price*qty); 
    } 
    void displaydetails(){ 
        System.out.println("Ticket Details"); 
        System.out.println("Ticket price: ₹ "+finalprice); 
        System.out.println("Quantity: "+quantity); 
    } 
} 
class concertticketbooking{
    public static void main (String[] args) throws java.lang.Exception{ 
        Scanner s=new Scanner(System.in); 
        System.out.println("Enter ticket details"); 
        System.out.println("Enter price:"); 
        System.out.println("Enter quantity:"); 
        double price=s.nextDouble(); 
        int qty=s.nextInt(); 
        concertticket s1=new concertticket(price, qty); 
        s1.displaydetails();
    }
}