package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import arten.Einzelgetraenk;
import arten.Saft;

public class TestHastable {

	public static void main(String[] args) {
		Hashtable<String, Einzelgetraenk> h = null;
		// = new Hashtable();
		try {
			FileInputStream fs = new FileInputStream("Zutaten.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			// for (int i = 0; i < h.size(); i++) { bin heir nie reingegangen lol
			h = (Hashtable<String, Einzelgetraenk>) in.readObject();
			// }

			in.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}

		if (h == null)
			h = new Hashtable<String, Einzelgetraenk>();

		if (h.isEmpty()) {
			System.out.println("fuck you leatherman");
			loadme(h);
		}
		// h.put("Birnensaft", new Saft("Birnensaft", 47, 2.0));
		System.out.println(h.get("Birnensaft").getKalorien());

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
	}

	public static void loadme(Hashtable<String, Einzelgetraenk> h) {
		h.put("Birnensaft", new Saft("Birnensaft", 47, 2.0));
	}

}
