package example.service;

public class SumService implements CalculationService {
	Iterable<Double> numbers = null;
		
	public void setNumbers( Iterable<Double> l ){
	    this.numbers = l;
	}
	
	public double calculate() {
	    double sum = 0.0;
	    for (Double d  : numbers ){
	    	sum += d;
	    }
	    return sum;
	}

}
