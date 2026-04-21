import java.util.*; 
class Customer { 
    String name; 
    int seatNumber; 
    Customer(String name, int seatNumber) { 
        this.name = name; 
        this.seatNumber = seatNumber; 
    } 
 
    void display() { 
        System.out.println("Customer Name: " + name); 
        System.out.println("Seat Number: " + seatNumber); 
        System.out.println("---------------------"); 
    } 
} 
 
class Show { 
    String movieName; 
    int totalSeats; 
    HashMap<Integer, Customer> bookings = new HashMap<>(); 
 
    Show(String movieName, int totalSeats) { 
        this.movieName = movieName; 
        this.totalSeats = totalSeats; 
    } 
 
    void displayShow() { 
        System.out.println("Movie: " + movieName); 
        System.out.println("Total Seats: " + totalSeats); 
        System.out.println("Booked Seats: " + bookings.size()); 
        System.out.println("---------------------"); 
    } 
 
    void bookSeat(String name, int seat) { 
        if (seat > totalSeats || seat <= 0) { 
            System.out.println("Invalid seat number."); 
        }  
        else if (bookings.containsKey(seat)) { 
            System.out.println("Seat already booked."); 
        }  
        else { 
            bookings.put(seat, new Customer(name, seat)); 
            System.out.println("Ticket booked successfully!"); 
        } 
    } 
 
    void viewCustomers() { 
        if (bookings.isEmpty()) { 
            System.out.println("No bookings yet."); 
        } else { 
            for (Customer c : bookings.values()) { 
                c.display(); 
            } 
        } 
    } 
} 
 
public class MovieTicketBooking { 
 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
 
        HashMap<Integer, Show> shows = new HashMap<>(); 
 
        while (true) { 
 
            try { 
 
                System.out.println("\n--- Movie Ticket Booking System ---"); 
                System.out.println("1. Add Show"); 
                System.out.println("2. View Shows"); 
                System.out.println("3. Book Ticket"); 
                System.out.println("4. View Customers"); 
                System.out.println("5. Exit"); 
 
                System.out.println("Enter choice: "); 
                int choice = sc.nextInt(); 
 
                switch (choice) { 
 
                    case 1: 
                        System.out.println("Enter Show ID: "); 
                        int id = sc.nextInt(); 
                        sc.nextLine(); 
 
                        System.out.println("Enter Movie Name: "); 
                        String movie = sc.nextLine(); 
 
                        System.out.println("Enter Total Seats: "); 
                        int seats = sc.nextInt(); 
 
                        shows.put(id, new Show(movie, seats)); 
                        System.out.println("Show added successfully!"); 
                        break; 
 
                    case 2: 
                        if (shows.isEmpty()) { 
                            System.out.println("No shows available."); 
                        } else { 
                            for (Show s : shows.values()) { 
                                s.displayShow(); 
                            } 
                        } 
                        break; 
 
                    case 3: 
                        System.out.println("Enter Show ID: "); 
                        int showId = sc.nextInt(); 
                        sc.nextLine(); 
 
                        if (shows.containsKey(showId)) { 
 
                            System.out.println("Enter Customer Name: "); 
                            String cname = sc.nextLine(); 
 
                            System.out.println("Enter Seat Number: "); 
                            int seat = sc.nextInt(); 
 
                            shows.get(showId).bookSeat(cname, seat); 
                        }  
                        else { 
                            System.out.println("Show not found."); 
                        } 
                        break; 
 
                    case 4: 
                        System.out.println("Enter Show ID: "); 
                        int sid = sc.nextInt(); 
 
                        if (shows.containsKey(sid)) { 
                            shows.get(sid).viewCustomers(); 
                        }  
                        else { 
                            System.out.println("Show not found."); 
                        } 
                        break; 
 
                    case 5: 
                        System.out.println("Exiting program..."); 
                        System.exit(0); 
 
                    default: 
                        System.out.println("Invalid choice."); 
 
                } 
 
            } catch (InputMismatchException e) { 
                System.out.println("Invalid input! Please enter correct data."); 
                sc.nextLine(); 
            } 
        } 
    } 
}