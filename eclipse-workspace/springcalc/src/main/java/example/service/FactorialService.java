package example.service;

public class FactorialService implements CalculationService {
	Iterable<Double> numbers = null;
		
	public void setNumbers( Iterable<Double> l ){
	    this.numbers = l;
	}
	
	public double calculate() {
	    double prod = 1.0;
	    for (Double d  : numbers ){
	    	prod *= d;
	    }
	    return prod;
	}

}
