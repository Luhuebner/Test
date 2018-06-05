package tests;

import java.util.Vector;

import arten.Cocktail;
import arten.Einzelgetraenk;
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
		Einzelgetraenk[] g = new Einzelgetraenk [3]; // array variabel machen
		g[0] = Karottensaft;
		g[1] = Orangensaft;
		g[2] = Birnensaft;
		Cocktail c1 = new Cocktail("Super-Saft", g);
		System.out.println(c1.getKalorien());
		System.out.println("hey");
		System.out.println("Test");
		System.out.println("test2");
		System.out.println("test3");
	}

}
