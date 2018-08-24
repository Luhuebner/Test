package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import arten.Alkoholfrei;
import arten.Alkoholisch;
import arten.Cocktail;
import arten.Einzelgetraenk;
import arten.Saft;
import arten.Softdrinks;

public class Programm {
	public static void main(String[] args) {
		// initialisieren der Hashtables
		Hashtable<String, Einzelgetraenk> hzutaten = null;
		Hashtable<String, Cocktail> hcocktail = null;
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();
		hzutaten = loadzutaten();
		hcocktail = loadcocktail(hzutaten);

		Scanner s = new Scanner(System.in);
		double wert = 0.00;
		int eingabei = 0;
		String eingabes = "";
		Set<String> keys = hcocktail.keySet();
		Set<String> zkeys = hzutaten.keySet();
		Iterator<String> itr = keys.iterator();
		boolean bpruef = false;
		String str;

		while (eingabei != 3) {
			System.out.println("Was moechten Sie tun? Druecken Sie die entsprechende Taste.");
			System.out.println("1: Cocktail erstellen \n2: Cocktail auswaehlen und bestellen \n3: Bar verlassen");
			eingabei = s.nextInt();
			s.nextLine();
			if (eingabei == 1) {
				while (eingabei == 1) {
					itr = zkeys.iterator();
					int k = 0;
					while (itr.hasNext()) {
						str = itr.next();
						if (k == 3) {
							System.out.println("Name: " + hzutaten.get(str).getName() + "\t\t\t");
							k = 0;
						} else {
							System.out.print("Name: " + hzutaten.get(str).getName() + "\t\t\t");
							k++;
						}

					}
					System.out.println("");
					bpruef = false;
					while(bpruef == false){
						System.out.println("Schreiben Sie den exakten Namen der Zutat die Sie in Ihrem Cocktail haben moechten.");
						eingabes = s.nextLine();
						itr = zkeys.iterator();
						
						while(itr.hasNext()){
							str = itr.next();
							if(eingabes.equals(hzutaten.get(str).getName())){
								bpruef = true;
							}
						}
						if(bpruef == false){
							System.out.println("Bitte ueberpruefen Sie Ihre Eingabe. Achten Sie auf Gross- und Kleinschreibung.");	
						}
					}
					
					
					list1.add(hzutaten.get(eingabes));
					System.out.println("Geben Sie nun die menge dieser Zutat an. (in cl)");
					eingabei = s.nextInt() * 10;

					list2.add(eingabei * 1.0);
					System.out.println(
							"Druecken Sie nun die 1 um eine weitere Zutat hinzuzufuegen, die 2 um die Erstellung abzuschliessen oder die 3 um die Erstellung abzubrechen.");
					eingabei = s.nextInt();
					s.nextLine();

					if (eingabei == 2) {
						// name eingeben
						System.out.println("Geben Sie Ihrem erstelltem Cocktail nun einen Namen.");
						eingabes = s.nextLine();
						// cocktail erstellen, in hashtable, und speichern
						hcocktail.put(eingabes, new Cocktail(eingabes, list1, list2));
						safe(hzutaten, hcocktail);
						System.out.println("Ihr Cocktail wurde gespeichert");
					} else if (eingabei == 3) {
						// arraylisten leern
						list1.clear();
						list2.clear();
						eingabei = 4;
					}
				}

			} else if (eingabei == 2) {
				// eingabei = 2;
				while (eingabei == 2) {
					itr = keys.iterator();
					int j = 1;
					while (itr.hasNext()) {
						str = itr.next();
						System.out.println(j + ": " + hcocktail.get(str).getName());
						j++;
					}
					
					bpruef = false;
					while(bpruef == false){
						System.out.println("Schreiben Sie den exakten Namen des Cocktails den Sie auswaehlen moechten.");
						eingabes = s.nextLine();
						itr = keys.iterator();
						
						while(itr.hasNext()){
							str = itr.next();
							if(eingabes.equals(hcocktail.get(str).getName())){
								bpruef = true;
							}
						}
						if(bpruef == false){
							System.out.println("Bitte ueberpruefen Sie Ihre Eingabe. Achten Sie auf Gross- und Kleinschreibung.");	
						}
					}
					
					
					System.out.println("Name: " + hcocktail.get(eingabes).getName());
					System.out.println("Kalorien: " + hcocktail.get(eingabes).getKalorien()+ " kcal");
					System.out.println("Alkoholgehalt: " + Math.round(hcocktail.get(eingabes).getAlkgehalt()) + "%");
					System.out.println("Preis: " + hcocktail.get(eingabes).getPreis() + " Euro");

					System.out.println("Moechten Sie einen " + eingabes + " fuer " + hcocktail.get(eingabes).getPreis()
							+ " bestellen?");
					System.out.println(
							"Druecken Sie die 1 zum bestellen, die 2 um zur Cocktailueberischt zurueck zugelangen oder die 3 um zur Hauptueberischt zu gelangen");
					eingabei = s.nextInt();
					s.nextLine();
					if (eingabei == 1) {
						// hcocktail.get(eingabes).kaufen();
						wert = wert + hcocktail.get(eingabes).getPreis();
						System.out.println("Viel spas¸ mit ihrem " + hcocktail.get(eingabes).getName() + ".");
					}
					if (eingabei == 3) { // variable wird auf 4 gesetzt um mit der ursprÃƒÆ’Ã‚Â¼nglichen while-schleife
											// das
											// programm nciht zu beenden
						eingabei = 4;
					}

				}
			}
		}
		// rechnung erstellen und anzeigen, immer wenn bestellt iwrd preis aufsummieren
		System.out.println("Vielen Dank fuer Ihren Besuch. Die Summe Ihrer Rechnung betraegt: " +  Double.valueOf(Math.round((wert)*100)/100.0) + " Euro"); // wert noch riwie auf 2 kommastellen anzeigen lassen
		safe(hzutaten, hcocktail);
	}

	private static Hashtable<String, Einzelgetraenk> loadzutaten() {
		// befÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼llen der Hashtable mit den vorhandenen Zutaten aus einer
		// datei
		// falls keine datei vorhanden wird eine Standartliste geladen
		Hashtable<String, Einzelgetraenk> hzutaten = null;
		try {
			FileInputStream fs = new FileInputStream("Zutaten.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			hzutaten = (Hashtable<String, Einzelgetraenk>) in.readObject();
			in.close();
		} catch (Exception e) {
//			System.err.println(e.toString());
			System.out.println("Es wurde ein initialer Zutatenbestand geladen.");
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
		// befÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼llen der Hashtable mit den vorhandenen Cocktails aus
		// einer datei
		// falls keine Datei vorhanden wird eine Standartliste geladen
		Hashtable<String, Cocktail> hcocktail = null;
		try {
			FileInputStream fs = new FileInputStream("Cocktail.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			hcocktail = (Hashtable<String, Cocktail>) in.readObject();
			in.close();
		} catch (Exception e) {
			//System.err.println(e.toString());
			System.out.println("Es wurde ein initialer Cocktailbestand geladen.");
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
		// speichern der hashtables fÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼r zutaten und cocktails in
		// dateien
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
		// initiale befÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼llung der zutaten in die Hashtable falls keine
		// datei
		// vorhanden war

		h.put("Mangosaft", new Saft("Mangosaft", 51.0, 1.0));
		h.put("Apfelsaft", new Saft("Apfelsaft", 46.0, 1.0));
		h.put("Ananassaft", new Saft("Ananassaft", 60.0, 1.0));
		h.put("Birnensaft", new Saft("Birnensaft", 47.0, 1.0));
		h.put("Orangensaft", new Saft("Orangensaft", 46.0, 1.0));
		h.put("Maracujasaft", new Saft("Maracujasaft", 50.0, 1.0));
		h.put("Karottensaft", new Saft("Karottensaft", 39.0, 1.0));
		h.put("Limettensaft", new Saft("Limettensaft", 29.0, 1.0));
		h.put("Zitronensaft", new Saft("Zitronensaft", 29.0, 1.0));
		h.put("Cranberrysaft", new Saft("Cranberrysaft", 46, 1.0));

		h.put("Wein", new Alkoholisch("Wein", 83.0, 11, 2.0));
		h.put("Whisky", new Alkoholisch("Whisky", 250.0, 43, 2.0));
		h.put("Weisser Rum", new Alkoholisch("Weisser Rum", 230.0, 40, 2.0));
		h.put("Jaegermeister", new Alkoholisch("Jaegermeister", 250.0, 30, 2.0));
		h.put("Hochprozentiger Rum", new Alkoholisch("Hochprozentiger Rum", 197.0, 70, 2.5));
		h.put("Pfirsichlikoer", new Alkoholisch("Pfirsichlikoer", 194.0, 20, 2.0));
		h.put("Brauner Rum", new Alkoholisch("Brauner Rum", 234.0, 40, 2.0));
		h.put("Cointreau", new Alkoholisch("Cointreau", 320.0, 34, 2.0));
		h.put("Wodka", new Alkoholisch("Wodka", 231.0, 40, 2.0));
		h.put("Gin", new Alkoholisch("Gin", 263.0, 45, 2.0));
		h.put("Tequila", new Alkoholisch("Tequila", 245.0, 35, 2.0));
		h.put("Triple Sec", new Alkoholisch("Triple Sec", 300.0, 34, 2.0));
		h.put("Blue Curacao", new Alkoholisch("Blue Curacao", 179.0, 20, 2.0));
		h.put("Apricot Brandy", new Alkoholisch("Apricot Brandy", 305.0, 27, 2.0));

		h.put("Cola", new Softdrinks("Cola", 38.0, 0.8));

		h.put("Red Bull", new Alkoholfrei("Red Bull", 45.0, 1.5));
		h.put("Kokosmilch", new Alkoholfrei("Kokosmilch", 230.0, 1.5));
		h.put("Mandelsirup", new Alkoholfrei("Mandelsirup", 234.0, 1.0));
		h.put("Zuckersirup", new Alkoholfrei("Zuckersirup", 201.0, 1.0));
		h.put("Grenadinesirup", new Alkoholfrei("Grenadinesirup", 268.0, 1.0));
		h.put("Cream of Coconut", new Alkoholfrei("Cream of Coconut", 330.0, 1.5));

	}

	private static void initcocktail(Hashtable<String, Einzelgetraenk> hzutaten,
			Hashtable<String, Cocktail> hcocktail) {
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();
		// Hashtable<String, Cocktail> hcocktail = new Hashtable<String, Cocktail>();

		list1.add(hzutaten.get("Whisky"));
		list1.add(hzutaten.get("Wein"));
		list2.add(60.0);
		list2.add(60.0);
		hcocktail.put("WhiskyWein", new Cocktail("WhiskyWein", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Wodka"));
		list1.add(hzutaten.get("Pfirsichlikoer"));
		list1.add(hzutaten.get("Cranberrysaft"));
		list1.add(hzutaten.get("Orangensaft"));
		list2.add(40.0);
		list2.add(40.0);
		list2.add(80.0);
		list2.add(80.0);
		hcocktail.put("Sex on the Beach", new Cocktail("Sex on the Beach", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Cream of Coconut"));
		list1.add(hzutaten.get("Weisser Rum"));
		list1.add(hzutaten.get("Kokosmilch"));
		list1.add(hzutaten.get("Ananassaft"));
		list2.add(40.0);
		list2.add(40.0);
		list2.add(20.0);
		list2.add(90.0);
		hcocktail.put("Pina Colada", new Cocktail("Pina Colada", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Wodka"));
		list1.add(hzutaten.get("Weisser Rum"));
		list1.add(hzutaten.get("Blue Curacao"));
		list1.add(hzutaten.get("Ananassaft"));
		list1.add(hzutaten.get("Cream of Coconut"));
		list2.add(20.0);
		list2.add(40.0);
		list2.add(10.0);
		list2.add(40.0);
		list2.add(20.0);
		hcocktail.put("Swimming Pool", new Cocktail("Swimming Pool", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Jaegermeister"));
		list1.add(hzutaten.get("Red Bull"));
		list2.add(20.0);
		list2.add(50.0);
		hcocktail.put("Flying Hirsch", new Cocktail("Flying Hirsch", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Tequila"));
		list1.add(hzutaten.get("Zitronensaft"));
		list1.add(hzutaten.get("Orangensaft"));
		list1.add(hzutaten.get("Grenadinesirup"));
		list2.add(60.0);
		list2.add(10.0);
		list2.add(120.0);
		list2.add(20.0);
		hcocktail.put("Tequila Sunrise", new Cocktail("Tequila Sunrise", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Brauner Rum"));
		list1.add(hzutaten.get("Zitronensaft"));
		list1.add(hzutaten.get("Cola"));
		list2.add(40.0);
		list2.add(10.0);
		list2.add(120.0);
		hcocktail.put("Cuba Libre", new Cocktail("Cuba Libre", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Brauner Rum"));
		list1.add(hzutaten.get("Weisser Rum"));
		list1.add(hzutaten.get("Triple Sec"));
		list1.add(hzutaten.get("Zuckersirup"));
		list1.add(hzutaten.get("Mandelsirup"));
		list1.add(hzutaten.get("Zitronensaft"));
		list2.add(40.0);
		list2.add(20.0);
		list2.add(20.0);
		list2.add(10.0);
		list2.add(10.0);
		list2.add(10.0);
		hcocktail.put("Mai Tai", new Cocktail("Mai Tai", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Wodka"));
		list1.add(hzutaten.get("Brauner Rum"));
		list1.add(hzutaten.get("Tequila"));
		list1.add(hzutaten.get("Cointreau"));
		list1.add(hzutaten.get("Gin"));
		list1.add(hzutaten.get("Zitronensaft"));
		list1.add(hzutaten.get("Orangensaft"));
		list1.add(hzutaten.get("Cola"));
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		hcocktail.put("Long Island Icetea", new Cocktail("Long Island Icetea", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Brauner Rum"));
		list1.add(hzutaten.get("Weisser Rum"));
		list1.add(hzutaten.get("Hochprozentiger Rum"));
		list1.add(hzutaten.get("Apricot Brandy"));
		list1.add(hzutaten.get("Grenadinesirup"));
		list1.add(hzutaten.get("Ananassaft"));
		list1.add(hzutaten.get("Orangensaft"));
		list1.add(hzutaten.get("Limettensaft"));
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		list2.add(10.0);
		list2.add(20.0);
		list2.add(40.0);
		list2.add(20.0);
		list2.add(30.0);
		hcocktail.put("Zombie", new Cocktail("Zombie", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Orangensaft"));
		list1.add(hzutaten.get("Ananassaft"));
		list1.add(hzutaten.get("Maracujasaft"));
		list1.add(hzutaten.get("Mangosaft"));
		list1.add(hzutaten.get("Zitronensaft"));
		list1.add(hzutaten.get("Grenadinesirup"));
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		list2.add(20.0);
		hcocktail.put("5 Fruechte Cocktail", new Cocktail("5 Fruechte Cocktail", list1, list2));
		list1.clear();
		list2.clear();

		list1.add(hzutaten.get("Wodka"));
		list1.add(hzutaten.get("Orangensaft"));
		list2.add(40.0);
		list2.add(80.0);
		hcocktail.put("Screwdriver", new Cocktail("Screwdriver", list1, list2));
		list1.clear();
		list2.clear();
	}

}
