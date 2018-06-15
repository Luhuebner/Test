package tests;

import java.util.ArrayList;

import arten.Alkoholisch;
import arten.Cocktail;
import arten.Einzelgetraenk;

public class KalorienTest {

	public static void main(String[] args) throws Exception{
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();

		list1.add(new Alkoholisch("Whisky", 250.0, 43,2.0));
		list1.add(new Alkoholisch("Wein", 83.0, 11,2.0));
		list2.add(300.0);
		list2.add(100.0);

		Cocktail c = new Cocktail("WhiskyWein", list1, list2);
		
		double expected = 833.0;
		
		if(c.getKalorien() != expected)
		{
			System.out.println("Expected " + expected + ", but got " + c.getKalorien());
			throw new Exception("Kalorienberechnung falsch!");
		}
		System.out.println("Kalorien: " + c.getKalorien());
		System.out.println("Test successful!");

	}

}
