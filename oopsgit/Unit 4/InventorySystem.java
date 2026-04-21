import java.util.*; 
class Product { 
    int id; 
    String name; 
    int quantity; 
    Product(int id, String name, int quantity) { 
        this.id = id; 
        this.name = name; 
        this.quantity = quantity; 
    } 
    void display() { 
        System.out.println("Product ID: " + id); 
        System.out.println("Product Name: " + name); 
        System.out.println("Stock Quantity: " + quantity); 
        System.out.println("---------------------------"); 
    } 
} 
 
public class InventorySystem { 
 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
 
        HashMap<Integer, Product> inventory = new HashMap<>(); 
 
        while (true) { 
            try { 
                System.out.println("\n--- Inventory Management System ---"); 
                System.out.println("1. Add Product"); 
                System.out.println("2. View Inventory"); 
                System.out.println("3. Update Stock"); 
                System.out.println("4. Remove Product"); 
                System.out.println("5. Exit"); 
 
                System.out.println("Enter your choice: "); 
                int choice = sc.nextInt(); 
 
                switch (choice) { 
 
                    case 1: 
                        System.out.println("Enter Product ID: "); 
                        int id = sc.nextInt(); 
                        sc.nextLine(); 
 
                        System.out.println("Enter Product Name: "); 
                        String name = sc.nextLine(); 
 
                        System.out.println("Enter Quantity: "); 
                        int qty = sc.nextInt(); 
 
                        Product p = new Product(id, name, qty); 
                        inventory.put(id, p); 
 
                        System.out.println("Product added successfully!"); 
                        break; 
 
                    case 2: 
                        if (inventory.isEmpty()) { 
                            System.out.println("Inventory is empty."); 
                        } else { 
                            for (Product product : inventory.values()) { 
                                product.display(); 
                            } 
                        } 
                        break; 
 
                    case 3: 
                        System.out.println("Enter Product ID to update stock: "); 
                        int updateId = sc.nextInt(); 
 
                        if (inventory.containsKey(updateId)) { 
                            System.out.println("Enter new quantity: "); 
                            int newQty = sc.nextInt(); 
                            inventory.get(updateId).quantity = newQty; 
                            System.out.println("Stock updated successfully!"); 
                        } else { 
                            System.out.println("Product not found."); 
                        } 
                        break; 
 
                    case 4: 
                        System.out.println("Enter Product ID to remove: "); 
                        int removeId = sc.nextInt(); 
 
                        if (inventory.containsKey(removeId)) { 
                            inventory.remove(removeId); 
                            System.out.println("Product removed successfully!"); 
                        } else { 
                            System.out.println("Product not found."); 
                        } 
                        break; 
 
                    case 5: 
                        System.out.println("Exiting program..."); 
                        System.exit(0); 
 
                    default: 
                        System.out.println("Invalid choice!"); 
 
                } 
 
            } catch (InputMismatchException e) { 
                System.out.println("Invalid input! Please enter correct data."); 
                sc.nextLine(); 
            } 
        } 
    } 
}