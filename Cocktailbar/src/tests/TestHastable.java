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
		Hashtable<String, Einzelgetraenk> h = new Hashtable();
		try {
			FileInputStream fs = new FileInputStream("Zutaten.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			for (int i = 0; i < h.size(); i++) {
				h =  in.readObject();
			}

			in.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		
		
		
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

}
