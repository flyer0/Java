package example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"service.xml");
		CalculationService calcService = (CalculationService) context
				.getBean("calculationService");
		System.out.println("Result: " + calcService.calculate());
	}
}
