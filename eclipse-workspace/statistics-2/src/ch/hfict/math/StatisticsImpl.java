package ch.hfict.math;
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


}
