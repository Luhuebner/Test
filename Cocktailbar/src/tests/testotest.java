package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import arten.Einzelgetraenk;

public class testotest {

	public static void main(String[] args) {
		Hashtable hzutaten = new Hashtable();

		try {
			FileOutputStream fs = new FileOutputStream("Test.cocktail");
			ObjectOutputStream out = new ObjectOutputStream(fs);
			for (int i = 0; i < hzutaten.size(); i++) {
				out.writeObject(hzutaten);
			}

			out.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		
		
		

		try {
			FileInputStream fs = new FileInputStream("Test.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			for (int i = 0; i < hzutaten.size(); i++) {
				hzutaten = (Hashtable) in.readObject();
			}

			in.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}
