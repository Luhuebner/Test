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
		Hashtable<String, Einzelgetraenk> hzutaten = new Hashtable();
		Hashtable<String, Cocktail> hcocktail = new Hashtable();
		load(hzutaten, hcocktail);
		

		
		
//		hzutaten.put("Whiskey", new Alkoholisch("Whisky", 250.0, 43,2.0));
//		hzutaten.put("Orangensaft", new Saft("Orangensaft", 46.0,1.0));
//		hzutaten.put("Apfelsaft", new Saft("Apfelsaft", 46.0,1.0));
//		hzutaten.put("Karottensaft", new Saft("Karottensaft", 39.0,1.0));
//		hzutaten.put("Wein", new Alkoholisch("Wein", 83.0, 11,2.0));
//		hzutaten.put("Birnensaft", new Saft("Birnensaft", 47, 2.0));
//		
//		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
//		ArrayList<Double> list2 = new ArrayList<>();
//
//		list1.add(new Alkoholisch("Whisky", 250.0, 43,2.0));
//		list1.add(new Alkoholisch("Wein", 83.0, 11,2.0));
//		list2.add(300.0);
//		list2.add(100.0);
//		hcocktail.put("WhiskyWein", new Cocktail("WhiskyWein", list1, list2));
//		list1.clear();
//		list2.clear();
		
		System.out.println(hcocktail.get("WhiskyWein").getAlkgehalt());
		
		safe(hzutaten, hcocktail);
	}

	private static void load(Hashtable<String, Einzelgetraenk> h, Hashtable<String, Cocktail> hh) {

		try {
			FileInputStream fs = new FileInputStream("Zutaten.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			for (int i = 0; i < h.size(); i++) {
				h = (Hashtable) in.readObject();
			}

			in.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}

		if (h.isEmpty()) {
			initzutaten(h);
		}
		try {
			FileInputStream fs = new FileInputStream("Cocktail.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			for (int i = 0; i < hh.size(); i++) {
				hh = (Hashtable) in.readObject();
			}

			in.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}

		if (hh.isEmpty()) {
			initcocktail(h,hh);
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
	private static void initzutaten(Hashtable h) {
		h.put("Whiskey", new Alkoholisch("Whisky", 250.0, 43,2.0));
		h.put("Orangensaft", new Saft("Orangensaft", 46.0,1.0));
		h.put("Apfelsaft", new Saft("Apfelsaft", 46.0,1.0));
		h.put("Karottensaft", new Saft("Karottensaft", 39.0,1.0));
		h.put("Wein", new Alkoholisch("Wein", 83.0, 11,2.0));
		h.put("Birnensaft", new Saft("Birnensaft", 47, 2.0));
		
		
	}
	private static void initcocktail(Hashtable<String, Einzelgetraenk> h, Hashtable<String, Cocktail> hh) {
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();

		list1.add( h.get("Whisky")); 
		list1.add( h.get("Wein")); 
		list2.add(300.0);
		list2.add(100.0);
		hh.put("WhiskyWein", new Cocktail("WhiskyWein", list1, list2));
		list1.clear();
		list2.clear();
		
		
	}

}
