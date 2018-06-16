package tests;

import java.util.ArrayList;

import arten.Alkoholisch;
import arten.Cocktail;
import arten.Einzelgetraenk;

public class KaufTest {

	public static void main(String[] args) throws Exception {
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();

		list1.add(new Alkoholisch("Whisky", 250.0, 43, 2.0));
		list1.add(new Alkoholisch("Wein", 83.0, 11, 2.0));
		list2.add(300.0);
		list2.add(100.0);

		Cocktail c = new Cocktail("WhiskyWein", list1, list2);
		c.kaufen();
		double expected = 150000 - 300;

		if (list1.get(0).getLagergehalt() != expected) {
			System.out.println("Expected " + expected + ", but got " + list1.get(0).getLagergehalt());
			throw new Exception("Kaufaktion falsch!");
		}
		System.out.println("Bestand: " + list1.get(0).getLagergehalt());
		System.out.println("Test successful!");

		double expected1 = 150000 - 100;

		if (list1.get(1).getLagergehalt() != expected1) {
			System.out.println("Expected " + expected1 + ", but got " + list1.get(1).getLagergehalt());
			throw new Exception("Kaufaktion falsch!");
		}
		System.out.println("Bestand: " + list1.get(1).getLagergehalt());
		System.out.println("Test 2 successful!");

	}

}
