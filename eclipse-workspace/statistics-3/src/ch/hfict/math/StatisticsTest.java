package ch.hfict.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StatisticsTest{

    
    
    public static void main(String[] args){
        try{
    Statistics s = new StatisticsImpl();
    
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    
    s.read(r);
    
	System.out.println("AVERAGE:" + s.getAverange());
	System.exit(0);
        }catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Something unexpected happend");
            System.exit(-1);
        }
    }

}
