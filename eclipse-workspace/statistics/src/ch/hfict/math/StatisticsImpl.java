package ch.hfict.math;

public class StatisticsImpl implements Statistics{
  private double[] numbers = null;
  private int last = 0;

  public StatisticsImpl(int size) {
      //Exceptions -- show exception if size < 0
      if(size<0) {
          throw new IllegalArgumentException("size must be > 0");
      }
    numbers = new double[size];
  }

  @Override
public void addNumber(double n) {
    numbers[last++] = n;
  }
  
  @Override
public double getAverange() {
      double sum = 0;
      for(int i=0;i<last;i++) {
          sum +=numbers[i];
      }
      return sum/last;
  }


}
