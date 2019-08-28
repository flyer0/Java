package ch.hfict.math;
import java.util.ArrayList;
public class StatisticsImpl implements Statistics{
  
  ArrayList<Double>numbers=new ArrayList<Double>(); // Arraylist collection definition
  


  public StatisticsImpl(int size) {
      
      Double dsize = (double) size; //Cast int to Double
      
    
    //Exceptions -- show exception if size < 0
      if(size<0) {
          throw new IllegalArgumentException("size must be > 0");
      }
    numbers.add(dsize);
  }

  @Override
  public void addNumber(double n) {
    numbers.add(n);
  }
  
  @Override
  public double getAverange() {
      double sum = 0;
      for(Double e:numbers ) {
          
          sum +=e;
         
      }
     return sum/numbers.size();


  }


}
