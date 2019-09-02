package ch.hfict.math;

public class StatisticsTest{

    
    
    public static void main(String[] args){
        try{
    Statistics s = new StatisticsImpl();
	s.addNumber(1.0);
	s.addNumber(2.0);
	s.addNumber(3.0);

	System.out.println("AVERAGE:" + s.getAverange());
	System.exit(0);
        }catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Something unexpected happend");
            System.exit(-1);
        }
    }

}
