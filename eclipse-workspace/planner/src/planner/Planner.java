package planner;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Planner {
    static Date startDate;
    static Date endDate;
    
    public static void main(String [] args) throws InterruptedException {
        setStartDate();

        System.out.println("This is the start Date: " + startDate);
    
        
        
        Task task1 = new Task("Aufgabe1",20);
        Project p = new Project();
        p.Task(task1);

        
        Task task2 = new Task("Aufgabe2",10);
        p.Task(task2);
        p.write();
        setEndDate();
        System.out.println("This is the end Date: " + endDate );
    }
    
    public static void setStartDate() {
        startDate = new Date();
    }
    
    public static void setEndDate() throws InterruptedException{
        //TimeUnit.SECONDS.sleep(5); // Test if the Date is different than the start Date.
        endDate = new Date();
   
    }


    
}
