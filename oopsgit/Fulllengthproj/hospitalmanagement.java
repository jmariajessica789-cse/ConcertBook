import java.util.*; 
class Person { 
    private int id; 
    private String name; 
    public Person(int id, String name) { 
        this.id = id; 
        this.name = name; 
    } 
    public int getId() { 
        return id; 
    } 
    public String getName() { 
        return name; 
    } 
    public void display() { 
        System.out.println("ID: " + id + " Name: " + name); 
    } 
} 
class Doctor extends Person { 
    private String specialization; 
    public Doctor(int id, String name, String specialization) { 
        super(id, name); 
        this.specialization = specialization; 
    } 
    public void display() { 
        System.out.println("Doctor Details"); 
        super.display(); 
        System.out.println("Specialization: " + specialization); 
    } 
} 
class Patient extends Person { 
    private String disease; 
    public Patient(int id, String name, String disease) { 
        super(id, name); 
        this.disease = disease; 
    } 
    public void display() { 
        System.out.println("Patient Details"); 
        super.display(); 
        System.out.println("Disease: " + disease); 
    } 
} 
class Hospital { 
    private List<Person> people = new ArrayList<>(); 
    public void addPerson(Person p) { 
        people.add(p); 
        System.out.println("Added Successfully"); 
    } 
    public void displayAll() { 
        for(Person p : people) { 
            p.display(); 
            System.out.println("----------------"); 
        } 
    } 
    public void search(int id) { 
        for(Person p : people) { 
            if(p.getId() == id) { 
                p.display(); 
                return; 
            } 
        } 
        System.out.println("Not Found"); 
    } 
} 
public class hospitalmanagement { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        Hospital hospital = new Hospital(); 
        while(true){ 
            System.out.println("1.Add Doctor"); 
            System.out.println("2.Add Patient"); 
            System.out.println("3.Display All"); 
            System.out.println("4.Search"); 
            System.out.println("5.Exit"); 
            int choice = sc.nextInt(); 
            switch(choice){ 
                case 1: 
                    System.out.println("Enter ID:"); 
                    int did = sc.nextInt(); 
                    System.out.println("Enter Name:"); 
                    String dname = sc.next(); 
                    System.out.println("Enter Specialization:"); 
                    String spec = sc.next(); 
                    hospital.addPerson(new Doctor(did,dname,spec)); 
                    break; 
                case 2: 
                    System.out.println("Enter ID:"); 
                    int pid = sc.nextInt(); 
                    System.out.println("Enter Name:"); 
                    String pname = sc.next(); 
                    System.out.println("Enter Disease:"); 
                    String dis = sc.next(); 
                    hospital.addPerson(new Patient(pid,pname,dis)); 
                    break; 
                case 3: 
                    hospital.displayAll(); 
                    break; 
                case 4: 
                    System.out.println("Enter ID:"); 
                    hospital.search(sc.nextInt()); 
                    break; 
                case 5: 
                    System.exit(0); 
            } 
        } 
    } 
}