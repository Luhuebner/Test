package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import arten.Alkoholfrei;
import arten.Alkoholisch;
import arten.Cocktail;
import arten.Einzelgetraenk;
import arten.Saft;
import arten.Softdrinks;

public class Programm {
	public static void main(String[] args) {
		Hashtable<String, Einzelgetraenk> hzutaten = null;
		Hashtable<String, Cocktail> hcocktail = null;

		hzutaten = loadzutaten();
		hcocktail = loadcocktail(hzutaten);

		System.out.println(hcocktail.get("WhiskyWein").getKalorien());
		System.out.println(hzutaten.get("Wein").getKalorien());

		safe(hzutaten, hcocktail);
	}

	
	private static Hashtable<String, Einzelgetraenk> loadzutaten() {
		Hashtable<String, Einzelgetraenk> hzutaten = null;
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
		return hzutaten;
	}
	private static Hashtable<String, Cocktail> loadcocktail(Hashtable<String, Einzelgetraenk> hzutaten) {
		Hashtable<String, Cocktail> hcocktail = null;
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
		return hcocktail;
	}
	private static void safe(Hashtable<String, Einzelgetraenk> hzutaten, Hashtable<String, Cocktail> hcocktail) {
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
	private static void initzutaten(Hashtable<String, Einzelgetraenk> h) {

		h.put("Ananassaft", new Saft("Ananassaft", 60.0, 1.0));
		h.put("Apfelsaft", new Saft("Apfelsaft", 46.0, 1.0));
		h.put("Birnensaft", new Saft("Birnensaft", 47, 1.0));
		h.put("Cranberrysaft", new Saft("Cranberrysaft", 46, 1.0));
		h.put("Mangosaft", new Saft("Mangosaft", 51.0, 1.0));
		h.put("Maracujasaft", new Saft("Maracujasaft", 50.0, 1.0));
		h.put("Karottensaft", new Saft("Karottensaft", 39.0, 1.0));
		h.put("Limettensaft", new Saft("Limettensaft", 29.0, 1.0));
		h.put("Orangensaft", new Saft("Orangensaft", 46.0, 1.0));
		h.put("Zitronensaft", new Saft("Zitronensaft", 29.0, 1.0));
		
		h.put("Wein", new Alkoholisch("Wein", 83.0, 11, 2.0));
		h.put("Whisky", new Alkoholisch("Whisky", 250.0, 43, 2.0));
		h.put("Wodka", new Alkoholisch("Wodka", 231.0, 40, 2.0));
		h.put("Weißer Rum", new Alkoholisch("Weißer Rum", 230.0, 40, 2.0));
		h.put("Brauner Rum", new Alkoholisch("Brauner Rum", 234.0, 40, 2.0));
		h.put("Hochprozentiger Rum", new Alkoholisch("Hochprozentiger Rum", 197.0, 70, 2.5));
		h.put("Jaegermeister", new Alkoholisch("Jaegermeister", 250.0, 30, 2.0));
		h.put("Pfirsichlikör", new Alkoholisch("Pfirsichlikör", 194.0, 20, 2.0));
		h.put("Cointreau", new Alkoholisch("Cointreau", 320.0, 34, 2.0));
		h.put("Gin", new Alkoholisch("Gin", 263.0, 45, 2.0));
		h.put("Triple sec", new Alkoholisch("Triple sec", 300.0, 34, 2.0));
		h.put("Tequila", new Alkoholisch("Tequila", 245.0, 35, 2.0));
		h.put("Blue Curacao", new Alkoholisch("Blue Curacao", 179.0, 20, 2.0));
		h.put("Apricot Brandy", new Alkoholisch("Apricot Brandy", 305.0, 27, 2.0));
		
		h.put("Cola", new Softdrinks("Cola", 38.0, 0.8));
		
		h.put("Kokosmilch", new Alkoholfrei("Kokosmilch", 230.0, 1.5));
		h.put("cream of coconut", new Alkoholfrei("cream of coconut", 330.0, 1.5));
		h.put("Red Bull", new Alkoholfrei("Red Bull", 45.0, 1.5));
		h.put("Zuckersirup", new Alkoholfrei("Zuckersirup", 201.0, 1.0));
		h.put("Grenadinesirup", new Alkoholfrei("Grenadinesirup", 268.0, 1.0));
		h.put("Mandelsirup", new Alkoholfrei("Mandelsirup", 234.0, 1.0));
		
		
		//sahne, eis, zitrone
	}
	private static void initcocktail(Hashtable<String, Einzelgetraenk> hzutaten,
			Hashtable<String, Cocktail> hcocktail) {
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();
		// Hashtable<String, Cocktail> hcocktail = new Hashtable<String, Cocktail>();

		list1.add(hzutaten.get("Whisky"));
		list1.add(hzutaten.get("Wein"));

		list2.add(300.0);
		list2.add(100.0);
		hcocktail.put("WhiskyWein", new Cocktail("WhiskyWein", list1, list2));
		list1.clear();
		list2.clear();
		System.out.println("lol");
		
		//https://www.cocktail-rezepte-4u.de/rezepte/top-30-cocktails.html
		//Sex on the beach, Pina colada, swimming pool, flying hirsch, tequila sunrise, cuba libre, mai tai, long island icetea
		//zombie, 5 fruechte cocktail, screwdriver

	}
}
