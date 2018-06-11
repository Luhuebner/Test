package arten;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Cocktail extends Getraenk {
	private Vector v; // zutaten
	private Vector vv; // mengen
	private double kalorien;
	private double alkgehalt;

	public Cocktail(String name, ArrayList zutaten, ArrayList mengen) {
		super(name);
		this.kalorien = 0;
		v = new Vector();
		vv = new Vector();
		
		v.addElement(zutaten);
		vv.addElement(mengen);
		
		Iterator it = zutaten.iterator();
		Iterator itt = mengen.iterator();
		
		while(it.hasNext()) {
			this.kalorien = kalorien + ((Einzelgetraenk) it.next()).getKalorien()*((double)itt.next()/100); // noch das für alkohol einfügen
		}
		
	}
	
//	public Cocktail(String name, Einzelgetraenk[] g1) {
//		super(name);
//
//		v = new Vector();
//		for (int i = 0; i < g1.length; i++) {
//			v.addElement(g1[i]);
//			kalorien = kalorien + g1[i].getKalorien();
//		}
//		kalorien = kalorien / g1.length;
//	}

	public void kaufen() {

	}

	public double getKalorien() {
		return kalorien;
	}

	public void setKalorien(double kalorien) {
		this.kalorien = kalorien;
	}

	public double getAlkgehalt() {
		return alkgehalt;
	}

	public void setAlkgehalt(double alkgehalt) {
		this.alkgehalt = alkgehalt;
	}

}
