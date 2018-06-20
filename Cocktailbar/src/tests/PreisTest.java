package tests;

import java.util.ArrayList;

import arten.Alkoholisch;
import arten.Cocktail;
import arten.Einzelgetraenk;

public class PreisTest {

	public static void main(String[] args) throws Exception{
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();

		list1.add(new Alkoholisch("Whisky", 250.0, 43,3.0));
		list1.add(new Alkoholisch("Wein", 83.0, 11,1.0));
		list2.add(300.0);
		list2.add(100.0);

		Cocktail c = new Cocktail("WhiskyWein", list1, list2);
		
		double expected = 11.99;
		
		if(c.getPreis() != expected)
		{
			System.out.println("Expected " + expected + ", but got " + c.getPreis());
			throw new Exception("Preisberechnung falsch!");
		}
		System.out.println("Preis: " + c.getPreis());
		System.out.println("Test successful!");

	}

}
