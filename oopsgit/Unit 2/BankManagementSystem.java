import java.util.Scanner; 
 
abstract class BankAccount { 
    protected int accountNumber; 
    protected String accountHolderName; 
    protected double balance; 
 
    BankAccount(int accountNumber, String accountHolderName, double balance) { 
        this.accountNumber = accountNumber; 
        this.accountHolderName = accountHolderName; 
        this.balance = balance; 
    } 
 
    abstract void deposit(double amount); 
    abstract void withdraw(double amount); 
 
    public void displayDetails() { 
        System.out.println("Account Number : " + accountNumber); 
        System.out.println("Account Holder : " + accountHolderName); 
        System.out.println("Balance        : " + balance); 
        System.out.println("-----------------------------"); 
    } 
} 
 
class SavingsAccount extends BankAccount { 
 
    SavingsAccount(int accNo, String name, double bal) { 
        super(accNo, name, bal); 
    } 
 
    @Override 
    void deposit(double amount) { 
        balance += amount; 
        System.out.println("Deposited: " + amount); 
    } 
 
    @Override 
    void withdraw(double amount) { 
        if (amount <= balance) { 
            balance -= amount; 
            System.out.println("Withdrawn: " + amount); 
        } else { 
            System.out.println("Insufficient Balance!"); 
        } 
    } 
} 
 
public class BankManagementSystem { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        System.out.println("Enter number of accounts: "); 
        int n = sc.nextInt(); 
 
        BankAccount[] accounts = new BankAccount[n]; 
 
        for (int i = 0; i < n; i++) { 
            System.out.println("\nEnter details for Account " + (i + 1)); 
 
            System.out.println("Account Number: "); 
            int accNo = sc.nextInt(); 
 
            sc.nextLine(); 
 
            System.out.println("Account Holder Name: "); 
            String name = sc.nextLine(); 
 
            System.out.println("Initial Balance: "); 
            double bal = sc.nextDouble(); 
 
            accounts[i] = new SavingsAccount(accNo, name, bal); 
 
            System.out.println("Enter deposit amount: "); 
            accounts[i].deposit(sc.nextDouble()); 
 
            System.out.println("Enter withdraw amount: "); 
            accounts[i].withdraw(sc.nextDouble()); 
        } 
 
        System.out.println("\n=== Account Details ==="); 
        for (BankAccount acc : accounts) { 
            acc.displayDetails(); 
        } 
 
        sc.close(); 
    } 
}