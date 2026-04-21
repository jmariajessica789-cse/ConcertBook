import java.util.*; 
interface Vehicle { 
    void rent(); 
} 
class Car implements Vehicle { 
    public void rent() { 
        System.out.println("Car rented successfully"); 
    } 
} 
class Bike implements Vehicle { 
    public void rent() { 
        System.out.println("Bike rented successfully"); 
    } 
} 
class Bus implements Vehicle { 
    public void rent() { 
        System.out.println("Bus rented successfully"); 
    } 
} 
class VehicleFactory { 
    public static Vehicle getVehicle(String type) throws Exception { 
        if(type.equalsIgnoreCase("Car")){
            return new Car();
        } 
        else if(type.equalsIgnoreCase("Bike")){ 
            return new Bike(); 
        }
        else if(type.equalsIgnoreCase("Bus")){ 
            return new Bus(); 
        }
        else{ 
            throw new Exception("Invalid Vehicle Type");
        } 
    } 
} 
public class FactoryPattern { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        ArrayList<Vehicle> rentedVehicles = new ArrayList<>(); 
        while(true) { 
            System.out.println("\nVehicle Rental System"); 
            System.out.println("1. Rent Vehicle"); 
            System.out.println("2. Show Rented Vehicles"); 
            System.out.println("3. Exit"); 
            System.out.print("Enter choice: "); 
            int choice = sc.nextInt(); 
            sc.nextLine(); 
            try { 
                if(choice == 1) { 
                    System.out.print("Enter Vehicle Type (Car/Bike/Bus): "); 
                    String type = sc.nextLine(); 
                    Vehicle v = VehicleFactory.getVehicle(type); 
                    v.rent(); 
                    rentedVehicles.add(v); 
                } 
                else if(choice == 2) { 
 
                    System.out.println("Rented Vehicles Count: " + rentedVehicles.size()); 
                } 
 
                else if(choice == 3) { 
                    break; 
                } 
 
                else { 
                    System.out.println("Invalid Choice"); 
                } 
 
            } catch(Exception e) { 
                System.out.println("Error: " + e.getMessage()); 
            } 
        } 
    } 
} 