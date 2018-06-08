package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import arten.Cocktail;
import arten.Einzelgetraenk;
import arten.Getraenk;
import arten.Saft;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Saft orangensaft = new Saft("O-Saft", 46);
		Saft apfelsaft = new Saft("Apfelsaft", 46);
		Saft karottensaft = new Saft("Karottensaft", 39);
		Saft birnensaft = new Saft("Birnensaft", 47);
		Vector v = new Vector();
		Einzelgetraenk[] g = new Einzelgetraenk[3]; // array variabel machen
		g[0] = karottensaft;
		g[1] = orangensaft;
		g[2] = birnensaft;
		Cocktail c1 = new Cocktail("Super-Saft", g);
		System.out.println(c1.getKalorien());
		
		
		Einzelgetraenk[] h = new Einzelgetraenk[100];
//		h[0] = karottensaft;

		try {
			FileInputStream fs = new FileInputStream("Test.cocktail");
			ObjectInputStream in = new ObjectInputStream(fs);
			for(int i = 0; i<h.length;i++) {
				h[i] = (Einzelgetraenk) in.readObject();
			}

			in.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		System.out.println(h[0].getName());
		try {
			FileOutputStream fs = new FileOutputStream("Test.cocktail");
			ObjectOutputStream out = new ObjectOutputStream(fs);
			for(int i = 0; i<h.length;i++) {
				out.writeObject(h[i]);
			}
			
			out.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
		System.out.println("end");
	}

}
