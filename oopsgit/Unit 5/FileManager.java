import java.io.File;  
import java.util.Scanner;  
public class FileManager {      
    public static void main(String[] args) {          
        Scanner sc = new Scanner(System.in);   
        while (true) {   
            System.out.println("\n=== FILE MANAGER ===");   
            System.out.println("1. List Files");   
            System.out.println("2. Exit");              
            System.out.print("Enter choice: ");              
            int choice = sc.nextInt();              
            sc.nextLine();    
            if (choice == 1) {   
                System.out.print("Enter folder path: ");   
                String path = sc.nextLine();                  
                File folder = new File(path);                  
                if (!folder.exists() || !folder.isDirectory()) {                      
                    System.out.println("Invalid folder path!");   
                    continue;   
                }   
                File[] files = folder.listFiles();   
                System.out.println("\nFiles & Folders:");   
                for (File f : files) {                      
                    if (f.isDirectory()) {   
                        System.out.println("[DIR] " + f.getName());   
                    } else {   
                        System.out.println("[FILE] " + f.getName());   
                    }   
                }   
            } else if (choice == 2) {   
                System.out.println("Exiting...");   
                break;   
            } else {   
                System.out.println("Invalid choice!");   
            }   
        }   
    }   
} 