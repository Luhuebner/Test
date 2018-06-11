package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import arten.Alkoholisch;
import arten.Cocktail;
import arten.Einzelgetraenk;
import arten.Getraenk;
import arten.Saft;

public class AlkoholTest {

	public static void main(String[] args) throws Exception {
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();

		list1.add(new Alkoholisch("Whisky", 46.0, 40));
		list1.add(new Alkoholisch("Wein", 46.0, 20));
		list2.add(100.0);
		list2.add(300.0);

		Cocktail c = new Cocktail("WhiskyWein", list1, list2);
		
		double expected = 25;
		
		if(c.getAlkgehalt() != expected)
		{
			System.out.println("Expected " + expected + ", but got " + c.getAlkgehalt());
			throw new Exception("Alkoholberechnung falsch!");
		}
		System.out.println("Alk: " + c.getAlkgehalt());
		System.out.println("Test successful!");
	}

}
