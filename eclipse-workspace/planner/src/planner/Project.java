package planner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Project {
    private ArrayList<Task> tasks = new ArrayList<Task>();
    
    public void Task(Task t) {
        tasks.add(t);
    }
    
    public void write() {
        try {
            BufferedWriter f = new BufferedWriter(new FileWriter("test.txt"));
            
            for(Task e:tasks) {
                System.out.print(e.descritpion);
                System.out.print(";");
                System.out.println(e.duration);
            }
            
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
