package ch.hfict.math;

public class Statistics{
  private double[] numbers = null;
  private int last = 0;

  public Statistics(int size) {
    numbers = new double[size];
  }

  public void addNumber(double n) {
    numbers[last++] = n;
  }

  public double getAverage(){
      double count=0;
      for(int i=0;i<last;i++){
	  count += numbers[last];
      }

      count=count / last;

      return count;
      
  }
}
