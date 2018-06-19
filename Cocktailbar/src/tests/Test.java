package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

import arten.Alkoholisch;
import arten.Cocktail;
import arten.Einzelgetraenk;
import arten.Getraenk;
import arten.Saft;
import compared.AlkAbComparator;
import compared.NameAbComparator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Saft orangensaft = new Saft("O-Saft", 46, 2.0);
		Saft apfelsaft = new Saft("Apfelsaft", 46, 2.0);
		Saft karottensaft = new Saft("Karottensaft", 39, 2.0);
		Saft birnensaft = new Saft("Birnensaft", 47, 2.0);
		Vector v = new Vector();
		Einzelgetraenk[] g = new Einzelgetraenk[3]; // array variabel machen
		
		ArrayList[][] gg = new ArrayList[2][1];
		ArrayList<Einzelgetraenk> list1 = new ArrayList<>();
		ArrayList<Double> list2 = new ArrayList<>();
		
		list1.add( new Saft("O-Saft", 46.0,1.0));
		list1.add( new Saft("Apfelsaft", 46.0,1.0));
		list1.add( new Saft("Karottensaft", 39.0,1.0));
		list2.add(150.0);
		list2.add(250.0);
		list2.add(300.0);
		gg[0][0] = list1;
		gg[1][0] = list2;
		
//		g[0] = karottensaft;
//		g[1] = orangensaft;
//		g[2] = birnensaft;
//		Cocktail c1 = new Cocktail("Super-Saft", g);
//		System.out.println(c1.getKalorien());
		Cocktail c2 = new Cocktail("Deluxe-Saft", list1, list2);
		System.out.println(c2.getKalorien());
	
		
		Einzelgetraenk[] h = new Einzelgetraenk[100];
		h[0] = karottensaft;

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
		
		h[0] = null;
		
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
		
		assert h[0] != null : "h[0] konnte nicht gelesen werden."; // wenn Behindert dann test mit if
		
		System.out.println("h[0]: " + h[0].getName());
		
		System.out.println("end");
		System.out.println(karottensaft.getLagergehalt());
		Hashtable t = new Hashtable();
		t.put("Karottensaft", karottensaft);
		
		Einzelgetraenk s = (Einzelgetraenk) t.get("Karottensaft");
		System.out.println(s.getLagergehalt());
		System.out.println(c2.generiereAnleitung());
		System.out.println(c2.getPreis());
		System.out.println(orangensaft.getLagergehalt());
		Saft s1 = new Saft("Test", 26.0,20.0);
		Einzelgetraenk E1 = new Einzelgetraenk("Test", 26.0,20.0, 1.0);
		System.out.println(E1.getPreis());
		System.out.println(E1.getAlkgehalt());
		list1.add(new Alkoholisch("Whisky", 250.0, 43,2.0));
		list1.add(new Alkoholisch("Wein", 83.0, 11,2.0));
		System.out.println("------------------");
		for(int i = 0;i<list1.size();i++) {
			System.out.println(list1.get(i).getAlkgehalt());
		}
		System.out.println("------------------");
		Collections.sort(list1, new AlkAbComparator());
		for(int i = 0;i<list1.size();i++) {
			System.out.println(list1.get(i).getAlkgehalt());
		}
//		System.out.println("------------------");
//		for(int i = 0;i<list1.size();i++) {
//			System.out.println(list1.get(i).getName());
//		}
//		System.out.println("------------------");
//		Collections.sort(list1, new NameAbComparator());
//		for(int i = 0;i<list1.size();i++) {
//			System.out.println(list1.get(i).getName());
//		}
		// test
		System.out.println("test");
		System.out.println("test2");
	}

}
