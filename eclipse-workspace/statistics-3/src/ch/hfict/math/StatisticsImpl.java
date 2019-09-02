package ch.hfict.math;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
public class StatisticsImpl implements Statistics{
  

  ArrayList<Double>numbers=new ArrayList<Double>(); // ArrayList collection definition

      
   
  

  @Override
  public void addNumber(double n) {
    numbers.add(n);
  }
  
  @Override
  public double getAverange() {
      double sum = 0;
      for(Double e:numbers ) { //Extended For-Loop
         
          sum +=e;
         
      }
     return sum/numbers.size();

  }


public int read(BufferedReader r) {

    int from=0;
    int last=0;
    String line;
    try {
        line = r.readLine();
        while(last>=0) {

            last = line.indexOf(' ',from);
            if(last > 0) {
                numbers.add(Double.valueOf(line.substring(from,last)));
            }
            from = last+1;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return from;

}
  


}
