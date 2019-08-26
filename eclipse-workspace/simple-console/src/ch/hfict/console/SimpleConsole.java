package ch.hfict.console;

import java.io.IOException;

public class SimpleConsole {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
          Timer timer = new Timer();
          timer.start();
    
    
    int c=' ';
    while(c!='s'){
        System.out.println("enter s to stop");
        try{
            c = System.in.read();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
        timer.stop();
        
    }
    }
}
