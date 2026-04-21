import java.util.*; 
interface Food { 
    void order(); 
    String getName(); 
} 
class Pizza implements Food { 
    public void order() { 
        System.out.println("Pizza Ordered Successfully"); 
    } 
    public String getName() { 
        return "Pizza"; 
    } 
} 
class Burger implements Food { 
    public void order() { 
        System.out.println("Burger Ordered Successfully"); 
    } 
    public String getName() { 
        return "Burger"; 
    } 
} 
class Sandwich implements Food { 
    public void order() { 
        System.out.println("Sandwich Ordered Successfully"); 
    } 
    public String getName() { 
        return "Sandwich"; 
    } 
} 
class OrderManager { 
    private List<Food> orders = new ArrayList<>(); 
    public void addOrder(Food food) { 
        orders.add(food); 
        food.order(); 
    } 
    public void showOrders() { 
        System.out.println("\nOrders List:"); 
        for(Food f : orders) { 
            System.out.println(f.getName()); 
        } 
    } 
} 
public class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        OrderManager manager = new OrderManager(); 
        while(true) { 
            System.out.println("=== Food Order System ==="); 
            System.out.println("1. Pizza"); 
            System.out.println("2. Burger"); 
            System.out.println("3. Sandwich"); 
            System.out.println("4. Show Orders"); 
            System.out.println("5. Exit"); 
            try { 
                System.out.print("Enter choice: "); 
                int choice = sc.nextInt(); 
                switch(choice) { 
                    case 1: 
                        manager.addOrder(new Pizza()); 
                        break; 
 
                    case 2: 
                        manager.addOrder(new Burger()); 
                        break; 
                    case 3: 
                        manager.addOrder(new Sandwich()); 
                        break; 
                    case 4: 
                        manager.showOrders(); 
                        break; 
                    case 5: 
                        System.exit(0); 
                    default: 
                        throw new Exception("Invalid Choice"); 
                } 
            } catch(Exception e) { 
                System.out.println("Error: " + e.getMessage()); 
                sc.nextLine(); 
            } 
        } 
    } 
}