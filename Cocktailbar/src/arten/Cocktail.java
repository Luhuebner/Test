package arten;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.stream.Collectors;

public class Cocktail extends Getraenk {
	private ArrayList<Einzelgetraenk> zutaten; // zutaten
	private ArrayList<Double> mengen; // mengen

	public Cocktail(String name, ArrayList<Einzelgetraenk> zutaten, ArrayList<Double> mengen) {
		super(name, 0, 0);
		this.zutaten = new ArrayList<>(zutaten);
		this.mengen = new ArrayList<>(mengen);

		for (int i = 0; i < zutaten.size(); ++i) {
			kalorien += zutaten.get(i).getKalorien() * mengen.get(i);
			alkgehalt += zutaten.get(i).getAlkgehalt() * mengen.get(i); // formel nciht ganz richtig
		}
		kalorien /= 100;
		alkgehalt /= mengen.stream().collect(Collectors.summingDouble(x -> x));

	}

	// public Cocktail(String name, Einzelgetraenk[] g1) {
	// super(name);
	//
	// v = new Vector();
	// for (int i = 0; i < g1.length; i++) {
	// v.addElement(g1[i]);
	// kalorien = kalorien + g1[i].getKalorien();
	// }
	// kalorien = kalorien / g1.length;
	// }

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
