import java.util.*; 
import java.lang.*; 
import java.io.*; 
class studentinfo{  
    String name;  
    String dept; 
    String yr;  
    studentinfo(){  
    }  
    studentinfo(String name,String dept,String yr){ 
        this.name=name; this.dept=dept; this.yr=yr;  
    }  
    void displaydetails(){  
        System.out.println("Student Details");  
        System.out.println("Name: "+name);  
        System.out.println("Department: "+dept);  
        System.out.println("Year: "+yr);  
    }  
}  
class studentinfomanager{  
    public static void main (String[] args) throws java.lang.Exception {  
        Scanner s=new Scanner(System.in);  
        System.out.println("Enter number of students"); 
        int n=s.nextInt();  
        s.nextLine(); 
        studentinfo[] a=new studentinfo[n];  
        for(int i=0;i<n;i++){  
            System.out.println("Enter student details "+(i+1));  
            System.out.println("Enter student name:");  
            System.out.println("Enter the department:");  
            System.out.println("Enter the year:");  
            String name1=s.nextLine(); 
            String dept1=s.nextLine(); 
            String yr1=s.nextLine(); 
            a[i]=new studentinfo(name1,dept1,yr1);  
        }  
        for(int i=0;i<n;i++){ 
            a[i].displaydetails();  
        }  
    }  
}  