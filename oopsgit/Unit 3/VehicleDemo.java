import java.util.Scanner; 
class Vehicle { 
    String brand; 
    int speed; 
    Vehicle(String brand, int speed) { 
        this.brand = brand; 
        this.speed = speed; 
    } 
    void displayInfo() { 
        System.out.println("Brand: " + brand); 
        System.out.println("Speed: " + speed + " km/h"); 
    } 
} 
class Car extends Vehicle { 
    int doors; 
    Car(String brand, int speed, int doors) { 
        super(brand, speed); 
        this.doors = doors; 
    } 
    void displayInfo() { 
        super.displayInfo(); 
        System.out.println("Doors: " + doors); 
        System.out.println("Type: Car"); 
    } 
} 
 
class Bike extends Vehicle { 
    boolean hasGear; 
 
    Bike(String brand, int speed, boolean hasGear) { 
        super(brand, speed); 
        this.hasGear = hasGear; 
    } 
 
    void displayInfo() { 
        super.displayInfo(); 
        System.out.println("Has Gear: " + (hasGear ? "Yes" : "No")); 
        System.out.println("Type: Bike"); 
    } 
} 
 
public class VehicleDemo { 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
 
        System.out.println("Enter Car Details"); 
        System.out.println("Brand: "); 
        String carBrand = sc.nextLine(); 
 
        System.out.println("Speed: "); 
        int carSpeed = sc.nextInt(); 
 
        System.out.println("Number of doors: "); 
        int doors = sc.nextInt(); 
 
        sc.nextLine(); 
 
        System.out.println("\nEnter Bike Details"); 
        System.out.println("Brand: "); 
        String bikeBrand = sc.nextLine(); 
 
        System.out.println("Speed: "); 
        int bikeSpeed = sc.nextInt(); 
 
        System.out.println("Has gear (true/false): "); 
        boolean hasGear = sc.nextBoolean(); 
 
        Car car = new Car(carBrand, carSpeed, doors); 
        Bike bike = new Bike(bikeBrand, bikeSpeed, hasGear); 
 
        System.out.println("\n--- Vehicle Details ---"); 
 
        System.out.println("\nCar Details:"); 
        car.displayInfo(); 
        System.out.println("\nBike Details:"); 
        bike.displayInfo(); 
        sc.close(); 
    } 
}