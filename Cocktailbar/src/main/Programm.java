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

		h.put("Orangensaft", new Saft("Orangensaft", 46.0, 1.0));
		h.put("Apfelsaft", new Saft("Apfelsaft", 46.0, 1.0));
		h.put("Karottensaft", new Saft("Karottensaft", 39.0, 1.0));
		h.put("Wein", new Alkoholisch("Wein", 83.0, 11, 2.0));
		h.put("Birnensaft", new Saft("Birnensaft", 47, 2.0));
		h.put("Whisky", new Alkoholisch("Whisky", 250.0, 43, 2.0));
		//Wodka, pfirsich likör/ cranberrysaft, Ananassaft, Kokosmilch, weißer rum, cream of coconut, sahne, blue curacao, eis, jägermeister, redbull
		// zitronensaft, tequila, grenadinesirup, cola, brauner rum, triple sec, zuckersirup, mandelsirup, zitrone, cointreau, gin
		//rum mit mehr alk, apricot brandy, grenadine sirup, limettensaft, mangosaft, maracujasaft
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
