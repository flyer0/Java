package ch.hfict.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class StatisticsTest{

    
    
    public static void main(String[] args){
        try{
    Statistics s = new StatisticsImpl();
   
    BufferedReader r = new BufferedReader(
            //new InputStreamReader(System.in)
            new StringReader("1 2 3")); // helps for testing. StringReader
    
    System.out.print("Eingabe mit Leerzeichen: ");
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
