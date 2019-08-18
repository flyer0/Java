package ch.hfict.math;

public class StatisticsTest{

    public static void main(String[] args){
        Statistics s = new Statistics(3);
	s.addNumber(1.0);
	s.addNumber(2.0);
	s.addNumber(4.0);

	System.out.println("AVERAGE: " + s.getAverage());
	System.exit(0);

    }

}
