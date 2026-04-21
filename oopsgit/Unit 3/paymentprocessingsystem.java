import java.util.Scanner; 
interface PaymentMethod { 
    void pay(double amount); 
} 
class Payment { 
    String payerName; 

    Payment(String payerName) { 
        this.payerName = payerName; 
    } 
} 
class CreditCardPayment extends Payment implements PaymentMethod { 
    CreditCardPayment(String name) { 
        super(name); 
    } 

    public void pay(double amount) { 
        System.out.println(payerName + " paid ₹" + amount + " using Credit Card."); 
    } 
} 
 
class UPIPayment extends Payment implements PaymentMethod { 
    UPIPayment(String name) { 
        super(name); 
    } 
 
    public void pay(double amount) { 
        System.out.println(payerName + " paid ₹" + amount + " using UPI."); 
    } 
} 
 
class CashPayment extends Payment implements PaymentMethod { 
    CashPayment(String name) { 
        super(name); 
    } 
 
    public void pay(double amount) { 
        System.out.println(payerName + " paid ₹" + amount + " using Cash."); 
    } 
} 
 
public class paymentprocessingsystem { 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
 
        System.out.print("Enter number of payments: "); 
        int n = sc.nextInt(); 
        sc.nextLine(); 
 
        PaymentMethod[] payments = new PaymentMethod[n]; 
 
        for (int i = 0; i < n; i++) { 
            System.out.println("\nPayment " + (i + 1)); 
            System.out.println("1. Credit Card"); 
            System.out.println("2. UPI"); 
            System.out.println("3. Cash"); 
            System.out.println("Choose payment type: "); 
            int choice = sc.nextInt(); 
            sc.nextLine(); 
 
            System.out.println("Enter payer name: "); 
            String name = sc.nextLine(); 
 
            System.out.println("Enter amount: "); 
            double amount = sc.nextDouble(); 
            sc.nextLine(); 
 
            switch (choice) { 
                case 1: 
                    payments[i] = new CreditCardPayment(name); 
                    break; 
                case 2: 
                    payments[i] = new UPIPayment(name); 
                    break; 
                case 3: 
                    payments[i] = new CashPayment(name); 
                    break; 
                    default: 
                        System.out.println("Invalid choice. Defaulting to Cash."); 
                        payments[i] = new CashPayment(name); 
            } 
            payments[i].pay(amount); 
        } 
        sc.close(); 
    } 
} 