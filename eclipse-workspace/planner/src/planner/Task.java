package planner;


public class Task {

    String descritpion;
    int duration;
    
    public Task(String s, int d) {    
        if(d<=0) {
            throw new IllegalArgumentException("Duration must be >0");
        }
        this.descritpion = s;
        this.duration = d;
        System.out.println("Duration is OK");


    }
}