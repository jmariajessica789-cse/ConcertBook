import java.util.*; 
class FoodItem { 
    int id; 
    String name; 
    double price; 
    FoodItem(int id, String name, double price) { 
        this.id = id; 
        this.name = name; 
        this.price = price; 
    } 
    void display() { 
        System.out.println(id + ". " + name + " - ₹" + price); 
    } 
} 
class Restaurant { 
    String name; 
    List<FoodItem> menu; 
    Restaurant(String name) { 
        this.name = name; 
        menu = new ArrayList<>(); 
    } 
    void addFood(FoodItem item) { 
        menu.add(item); 
    } 
    void showMenu() { 
        System.out.println("Menu - " + name); 
        for (FoodItem f : menu) { 
            f.display(); 
        } 
    } 
} 
class Cart { 
    List<FoodItem> items = new ArrayList<>(); 
    void addItem(FoodItem item) { 
        items.add(item); 
        System.out.println(item.name + " added to cart"); 
    } 
    void showCart() { 
        double total = 0; 
        System.out.println("Your Cart"); 
        for (FoodItem f : items) { 
            System.out.println(f.name + " - ₹" + f.price); 
            total += f.price; 
        } 
        System.out.println("Total = ₹" + total); 
    } 
} 
 
public class FoodDeliveryApp { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        Cart cart = new Cart(); 
        Restaurant r1 = new Restaurant("Pizza Hut"); 
        r1.addFood(new FoodItem(1, "Veg Pizza", 200)); 
        r1.addFood(new FoodItem(2, "Cheese Pizza", 250)); 
 
        Restaurant r2 = new Restaurant("KFC"); 
        r2.addFood(new FoodItem(1, "Chicken Bucket", 500)); 
        r2.addFood(new FoodItem(2, "Burger", 150)); 
 
        List<Restaurant> restaurants = Arrays.asList(r1, r2); 
 
        int choice; 
        do { 
            System.out.println(" Food Delivery App "); 
            System.out.println("1. View Restaurants"); 
            System.out.println("2. View Cart"); 
            System.out.println("3. Place Order"); 
            System.out.println("4. Exit"); 
 
            choice = sc.nextInt(); 
            switch (choice) { 
                case 1: 
                    System.out.println("Restaurants:"); 
                    for (int i = 0; i < restaurants.size(); i++) { 
                        System.out.println((i + 1) + ". " + restaurants.get(i).name); 
                    } 
 
                    System.out.print("Select Restaurant: "); 
                    int rChoice = sc.nextInt(); 
                    Restaurant selected = restaurants.get(rChoice - 1); 
                    selected.showMenu(); 
                    System.out.print("Select Food ID: "); 
                    int foodId = sc.nextInt(); 
                    cart.addItem(selected.menu.get(foodId - 1)); 
                    break; 
                case 2: 
                    cart.showCart(); 
                    break; 
                case 3: 
                    System.out.println("Order Placed Successfully!"); 
                    cart.showCart(); 
                    break; 
                case 4: 
                    System.out.println("Thank You!"); 
                    break; 
                default: 
                    System.out.println("Invalid choice"); 
            } 
        } while (choice != 4); 
    } 
}