package ch.hfict.console;

import java.util.Date;

public class Timer implements Runnable{

    private Thread thread;

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        thread = null;
    }
    
    @Override
    public void run() {
        while(thread != null) {
           display();
           try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        
    }

    private void display() {
        // TODO Auto-generated method stub
        System.out.println(new Date());
        
    }


}
