package tests;

import java.util.Vector;

import arten.Cocktail;
import arten.Getraenk;
import arten.Saft;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Saft Orangensaft = new Saft("O-Saft", 46);
		Saft Apfelsaft = new Saft("Apfelsaft", 46);
		Saft Karottensaft = new Saft("Karottensaft", 39);
		Saft Birnensaft = new Saft("Birnensaft", 47 );
		Vector v = new Vector();
		Getraenk[] g = new Getraenk [2]; // array variabel machen
		g[0] = Karottensaft;
		g[1] = Orangensaft;
		Cocktail c1 = new Cocktail("Super-Saft", g);
		System.out.println(c1.getKalorien());
		System.out.println("hey");
		System.out.println("Test");
	}

}
