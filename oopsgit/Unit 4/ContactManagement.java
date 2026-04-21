import java.util.*; 
class Contact { 
    String name; 
    String phone; 
    String email; 
    Contact(String name, String phone, String email) { 
        this.name = name; 
        this.phone = phone; 
        this.email = email; 
    } 
    void display() { 
        System.out.println("Name: " + name); 
        System.out.println("Phone: " + phone); 
        System.out.println("Email: " + email); 
        System.out.println("-----------------------"); 
    } 
} 
 
public class ContactManagement { 
 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
 
        ArrayList<Contact> contacts = new ArrayList<>(); 
 
        int choice; 
 
        while (true) { 
            try { 
                System.out.println("\n--- Contact Management System ---"); 
                System.out.println("1. Add Contact"); 
                System.out.println("2. View Contacts"); 
                System.out.println("3. Search Contact"); 
                System.out.println("4. Delete Contact"); 
                System.out.println("5. Exit"); 
 
                System.out.println("Enter your choice: "); 
                choice = sc.nextInt(); 
                sc.nextLine();  
 
                switch (choice) { 
 
                    case 1: 
                        System.out.println("Enter Name: "); 
                        String name = sc.nextLine(); 
 
                        System.out.println("Enter Phone: "); 
                        String phone = sc.nextLine(); 
 
                        System.out.println("Enter Email: "); 
                        String email = sc.nextLine(); 
 
                        Contact c = new Contact(name, phone, email); 
                        contacts.add(c); 
 
                        System.out.println("Contact added successfully!"); 
                        break; 
 
                    case 2: 
                        if (contacts.isEmpty()) { 
                            System.out.println("No contacts available."); 
                        } else { 
                            for (Contact contact : contacts) { 
                                contact.display(); 
                            } 
                        } 
                        break; 
 
                    case 3: 
                        System.out.println("Enter name to search: "); 
                        String searchName = sc.nextLine(); 
                        boolean found = false; 
 
                        for (Contact contact : contacts) { 
                            if (contact.name.equalsIgnoreCase(searchName)) { 
                                contact.display(); 
                                found = true; 
                            } 
                        } 
 
                        if (!found) { 
                            System.out.println("Contact not found."); 
                        } 
                        break; 
 
                    case 4: 
                        System.out.println("Enter name to delete: "); 
                        String deleteName = sc.nextLine(); 
                        boolean removed = false; 
 
                        Iterator<Contact> it = contacts.iterator(); 
 
                        while (it.hasNext()) { 
                            Contact contact = it.next(); 
                            if (contact.name.equalsIgnoreCase(deleteName)) { 
                                it.remove(); 
                                System.out.println("Contact deleted successfully!"); 
                                removed = true; 
                                break; 
                            } 
                        } 
 
                        if (!removed) { 
                            System.out.println("Contact not found."); 
                        } 
                        break; 
 
                    case 5: 
                        System.out.println("Exiting program..."); 
                        System.exit(0); 
 
                    default: 
                        System.out.println("Invalid choice!"); 
                } 
            } catch (InputMismatchException e) { 
                System.out.println("Invalid input! Please enter numbers only."); 
                sc.nextLine(); 
            } 
        } 
    } 
} 