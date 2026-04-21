import java.util.Scanner; 
 
class Employee { 
    private int empId; 
    private String empName; 
    private String department; 
    private double salary; 
    public Employee(){ 
       
    } 
    public Employee(int emId, String empName, String department, double salary){ 
      this.empId=empId; 
      this.empName=empName; 
      this.department=department; 
      this.salary=salary; 
    } 
 
    public void setEmpId(int empId) { 
        this.empId = empId; 
    } 
 
    public void setEmpName(String empName) { 
        this.empName = empName; 
    } 
 
    public void setDepartment(String department) { 
        this.department = department; 
    } 
 
    public void setSalary(double salary) { 
        this.salary = salary; 
    } 
 
    public int getEmpId() { 
        return empId; 
    } 
 
    public String getEmpName() { 
        return empName; 
    } 
 
    public String getDepartment() { 
        return department; 
    } 
 
    public double getSalary() { 
        return salary; 
    } 
 
    public void displayEmployee() { 
        System.out.println("Employee ID     : " + empId); 
        System.out.println("Employee Name   : " + empName); 
        System.out.println("Department      : " + department); 
        System.out.println("Salary          : " + salary); 
        System.out.println("----------------------------"); 
    } 
} 
 
public class EmployeeManagement { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        System.out.println("Enter number of employees: "); 
        int n = sc.nextInt(); 
 
        Employee[] emp = new Employee[n]; 
 
        for (int i = 0; i < n; i++) { 
            emp[i] = new Employee(); 
 
            System.out.println("\nEnter details for Employee " + (i + 1)); 
 
            System.out.println("Employee ID: "); 
            emp[i].setEmpId(sc.nextInt()); 
 
            sc.nextLine(); 
 
            System.out.println("Employee Name: "); 
            emp[i].setEmpName(sc.nextLine()); 
 
            System.out.println("Department: "); 
            emp[i].setDepartment(sc.nextLine()); 
 
            System.out.println("Salary: "); 
            emp[i].setSalary(sc.nextDouble()); 
        } 
 
        System.out.println("\n=== Employee Details ==="); 
        for (Employee e : emp) { 
            e.displayEmployee(); 
        } 
 
        sc.close(); 
    } 
} 