package tests;

import java.util.ArrayList;
import java.util.Collections;

import arten.Alkoholisch;
import arten.Cocktail;
import arten.Einzelgetraenk;
import compared.AlkAbComparator;
import compared.AlkAufComparator;

public class SortierTest {

	public static void main(String[] args) throws Exception{
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();

		list1.add(new Alkoholisch("Whisky", 250.0, 43,2.0));
		list1.add(new Alkoholisch("Wein", 83.0, 11,2.0));
		list1.add(new Alkoholisch("Sodawasser", 0.0, 0,0.50));
		list1.add(new Alkoholisch("Rum", 231.0, 40,2.0));
		list1.add(new Alkoholisch("Cola", 38.0, 0,2.0));
		
		Collections.sort(list1, new AlkAufComparator());
		
		for(int i =0;i<list1.size();i++) {
			System.out.println(list1.get(i).getName());
		}

	}

}
