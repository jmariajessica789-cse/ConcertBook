import java.util.Scanner; 
 
interface Payroll { 
    void calculateSalary(); 
    void displayDetails(); 
} 
 
class Employee implements Payroll { 
    private int empId; 
    private String empName; 
    private double basicSalary; 
    private double netSalary; 
 
    Employee(int empId, String empName, double basicSalary) { 
        this.empId = empId; 
        this.empName = empName; 
        this.basicSalary = basicSalary; 
    } 
 
    @Override 
    public void calculateSalary() { 
        double hra = basicSalary * 0.20; 
        double da = basicSalary * 0.10; 
        netSalary = basicSalary + hra + da; 
    } 
 
    @Override 
    public void displayDetails() { 
        System.out.println("Employee ID   : " + empId); 
        System.out.println("Employee Name : " + empName); 
        System.out.println("Net Salary    : " + netSalary); 
        System.out.println("----------------------------"); 
    } 
} 
 
public class EmployeePayrollSystem { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        System.out.print("Enter number of employees: "); 
        int n = sc.nextInt(); 
 
        Payroll[] emp = new Payroll[n]; 
 
        for (int i = 0; i < n; i++) { 
            System.out.println("\nEnter details for Employee " + (i + 1)); 
 
            System.out.print("Employee ID: "); 
            int id = sc.nextInt(); 
 
            sc.nextLine(); 
 
            System.out.print("Employee Name: "); 
            String name = sc.nextLine(); 
 
            System.out.print("Basic Salary: "); 
            double salary = sc.nextDouble(); 
 
            emp[i] = new Employee(id, name, salary); 
            emp[i].calculateSalary(); 
        } 
 
        System.out.println("\n=== Payroll Details ==="); 
        for (Payroll e : emp) { 
            e.displayDetails(); 
        } 
 
        sc.close(); 
    } 
} 