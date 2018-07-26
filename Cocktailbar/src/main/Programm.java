package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import arten.Alkoholisch;
import arten.Cocktail;
import arten.Einzelgetraenk;
import arten.Saft;

public class Programm {
	public static void main(String[] args) {
//		Hashtable<String, Einzelgetraenk> hzutaten = null;
//		Hashtable<String, Cocktail> hcocktail = null;
//		load(hzutaten, hcocktail);

		// System.out.println(hzutaten.get("Birnensaft").getKalorien());
		// System.out.println(hcocktail.get("WhiskyWein").getAlkgehalt());

//		safe(hzutaten, hcocktail);
		
		Hashtable<String, Einzelgetraenk> hzutaten = null;
		Hashtable<String, Cocktail> hcocktail = null;
		
		try {
			FileInputStream fs = new FileInputStream("Zutaten.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			hzutaten = (Hashtable<String, Einzelgetraenk>) in.readObject();
			in.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		if (hzutaten == null) {
			hzutaten = new Hashtable<String, Einzelgetraenk>();
		}
		if (hzutaten.isEmpty()) {
			initzutaten(hzutaten);
		}
	
		
		try {
			FileInputStream fs = new FileInputStream("Cocktail.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			hcocktail = (Hashtable<String, Cocktail>) in.readObject();
			in.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		if (hcocktail == null) {
			hcocktail = new Hashtable<String, Cocktail>();
		}
		if (hcocktail.isEmpty()) {
			initcocktail(hzutaten, hcocktail);
		}
		
		
	
		
		System.out.println(hcocktail.get("WhiskyWein").getKalorien());
		System.out.println(hzutaten.get("Wein").getKalorien());
		
		
		
		try {

			FileOutputStream fs = new FileOutputStream("Cocktail.cocktail");
			ObjectOutputStream out = new ObjectOutputStream(fs);
			for (int i = 0; i < hcocktail.size(); i++) {
				out.writeObject(hcocktail);
			}
			out.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		try {

			FileOutputStream fs = new FileOutputStream("Zutaten.cocktail");
			ObjectOutputStream out = new ObjectOutputStream(fs);
			for (int i = 0; i < hzutaten.size(); i++) {
				out.writeObject(hzutaten);
			}
			out.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	private static void load(Hashtable<String, Einzelgetraenk> hzutaten, Hashtable<String, Cocktail> hcocktail) {
		try {
			FileInputStream fs = new FileInputStream("Zutaten.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			// for (int i = 0; i < h.size(); i++) {
			hzutaten = (Hashtable<String, Einzelgetraenk>) in.readObject();
			// }

			in.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}

		if (hzutaten == null) {

			hzutaten = new Hashtable<String, Einzelgetraenk>();
		}

		if (hzutaten.isEmpty()) {
			hzutaten = initzutaten();
			// initzutaten(hzutaten);
		}
		try {
			FileInputStream fs = new FileInputStream("Cocktail.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			// for (int i = 0; i < hh.size(); i++) {
			hcocktail = (Hashtable<String, Cocktail>) in.readObject();
			// }

			in.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}

		if (hcocktail == null) {

			hcocktail = new Hashtable<String, Cocktail>();
		}

		if (hcocktail.isEmpty()) {

			hcocktail = initcocktail(hzutaten);
		}
	}

	private static void safe(Hashtable h, Hashtable hh) {
		try {
			FileOutputStream fs = new FileOutputStream("Zutaten.cocktail");
			ObjectOutputStream out = new ObjectOutputStream(fs);
			for (int i = 0; i < h.size(); i++) {
				out.writeObject(h);
			}

			out.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		try {
			FileOutputStream fs = new FileOutputStream("Cocktail.cocktail");
			ObjectOutputStream out = new ObjectOutputStream(fs);
			for (int i = 0; i < hh.size(); i++) {
				out.writeObject(hh);
			}

			out.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	private static void initzutaten(Hashtable<String, Einzelgetraenk> h) {
		
		
		h.put("Orangensaft", new Saft("Orangensaft", 46.0, 1.0));
		h.put("Apfelsaft", new Saft("Apfelsaft", 46.0, 1.0));
		h.put("Karottensaft", new Saft("Karottensaft", 39.0, 1.0));
		h.put("Wein", new Alkoholisch("Wein", 83.0, 11, 2.0));
		h.put("Birnensaft", new Saft("Birnensaft", 47, 2.0));
		h.put("Whisky", new Alkoholisch("Whisky", 250.0, 43, 2.0));
	}

	private static void initcocktail(Hashtable<String, Einzelgetraenk> hzutaten, Hashtable<String, Cocktail> hcocktail) {
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();
//		Hashtable<String, Cocktail> hcocktail = new Hashtable<String, Cocktail>();

		list1.add(hzutaten.get("Whisky"));
		list1.add(hzutaten.get("Wein"));
		
		list2.add(300.0);
		list2.add(100.0);
		hcocktail.put("WhiskyWein", new Cocktail("WhiskyWein", list1, list2));
		list1.clear();
		list2.clear();
		System.out.println("lol");
		
	}

}
