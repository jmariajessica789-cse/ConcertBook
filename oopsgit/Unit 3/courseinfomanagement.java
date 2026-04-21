import java.util.Scanner; 
class Course { 
    String courseName; 
    int duration; 
    void showOnlineDetails(String name, int duration, String platform) { 
        System.out.println("Online Course Details"); 
        System.out.println("Course Name: " + name); 
        System.out.println("Duration: " + duration + " weeks"); 
        System.out.println("Platform: " + platform); 
    } 
    void showOfflineDetails(String name, int duration, String classroom) { 
        System.out.println("Offline Course Details"); 
        System.out.println("Course Name: " + name); 
        System.out.println("Duration: " + duration + " weeks"); 
        System.out.println("Classroom: " + classroom); 
    } 
} 
public class courseinfomanagement { 
    public static void main(String[] args) { 
        Scanner s = new Scanner(System.in); 
        System.out.println("Enter type of course:"); 
        System.out.println("1. Online Course"); 
        System.out.println("2. Offline Course"); 
 
        int type = s.nextInt(); 
        s.nextLine(); 
 
        Course c = new Course(); 
 
        switch (type) { 
            case 1: 
                System.out.println("Enter the course name: "); 
                String courseName1 = s.nextLine(); 
 
                System.out.println("Enter the duration (weeks): "); 
                int duration1 = s.nextInt(); 
                s.nextLine(); 
 
                System.out.println("Enter the platform: "); 
                String platform = s.nextLine(); 
 
                c.showOnlineDetails(courseName1, duration1, platform); 
                break; 
 
            case 2: 
                System.out.println("Enter the course name: "); 
                String courseName2 = s.nextLine(); 
 
                System.out.println("Enter the duration (weeks): "); 
                int duration2 = s.nextInt(); 
                s.nextLine(); 
 
                System.out.println("Enter the classroom: "); 
                String classroom = s.nextLine(); 
 
                c.showOfflineDetails(courseName2, duration2, classroom); 
                break; 
 
            default: 
                System.out.println("Invalid choice. Select from the options."); 
        } 
 
        s.close(); 
    } 
} 