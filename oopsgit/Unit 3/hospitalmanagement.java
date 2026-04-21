import java.util.Scanner; 
class Person { 
    String name; 
    int age; 
    Person(String name, int age) { 
        this.name = name; 
        this.age = age; 
    } 
    void displayInfo() { 
        System.out.println("Name: " + name); 
        System.out.println("Age: " + age); 
    } 
} 
class Doctor extends Person { 
    String specialization; 
    Doctor(String name, int age, String specialization) { 
        super(name, age); 
        this.specialization = specialization; 
    } 
 
    void displayInfo() { 
        super.displayInfo(); 
        System.out.println("Specialization: " + specialization); 
        System.out.println("Role: Doctor"); 
    } 
} 
 
class Patient extends Person { 
    String disease; 
 
    Patient(String name, int age, String disease) { 
        super(name, age); 
        this.disease = disease; 
    } 
 
    void displayInfo() { 
        super.displayInfo(); 
        System.out.println("Disease: " + disease); 
        System.out.println("Role: Patient"); 
    } 
} 
 
public class HospitalDemo { 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
 
        System.out.println("Enter Doctor Details"); 
        System.out.println("Name: "); 
        String docName = sc.nextLine(); 
 
        System.out.println("Age: "); 
        int docAge = sc.nextInt(); 
        sc.nextLine(); 
 
        System.out.println("Specialization: "); 
        String specialization = sc.nextLine(); 
 
        System.out.println("\nEnter Patient Details"); 
        System.out.println("Name: "); 
        String patName = sc.nextLine(); 
 
        System.out.println("Age: "); 
        int patAge = sc.nextInt(); 
        sc.nextLine(); 
 
        System.out.println("Disease: "); 
        String disease = sc.nextLine(); 
 
        Doctor doctor = new Doctor(docName, docAge, specialization); 
        Patient patient = new Patient(patName, patAge, disease); 
 
        System.out.println("\n--- Hospital Records ---"); 
        System.out.println("\nDoctor Details:"); 
        doctor.displayInfo(); 
        System.out.println("\nPatient Details:"); 
        patient.displayInfo(); 
        sc.close(); 
    } 
} 