package arten;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.stream.Collectors;

public class Cocktail extends Getraenk{
	private ArrayList<Einzelgetraenk> zutaten; // zutaten
	private ArrayList<Double> mengen; // mengen
	

	public Cocktail(String name, ArrayList<Einzelgetraenk> zutaten, ArrayList<Double> mengen) {
		super(name, 0, 0,0);
		this.zutaten = new ArrayList<>(zutaten);
		this.mengen = new ArrayList<>(mengen);

		for (int i = 0; i < zutaten.size(); ++i) {
			kalorien += zutaten.get(i).getKalorien() * mengen.get(i);
			alkgehalt += zutaten.get(i).getAlkgehalt() * mengen.get(i);
			preis += zutaten.get(i).getPreis()*mengen.get(i)/100;
		}
		kalorien /= 100;
		alkgehalt /= mengen.stream().collect(Collectors.summingDouble(x -> x));
		preis =Math.round(preis * (1+zutaten.size()/10))-0.01 ;

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

	public void kaufen() throws Exception {
		for (int i = 0; i < this.zutaten.size(); i++) {
			if (zutaten.get(i).getLagergehalt() - mengen.get(i) < 0) {
				throw new Exception("Lagerbestand für die Zutat" + zutaten.get(i).getName() + " zu niedrig.");
			}
			zutaten.get(i).setLagergehalt(zutaten.get(i).getLagergehalt() - mengen.get(i));
		}

	}
	public String generiereAnleitung() {
		String anleitung;
		StringBuilder sb = new StringBuilder();
		sb.append("Um den Cocktail " + this.getName() + " zuzubereiten benötigt man:\n");
		for(int i=0; i<this.zutaten.size();i++) {
			sb.append(this.mengen.get(i) + " gramm " + this.zutaten.get(i).getName() + "\n");
		}
		sb.append("Diese schüttet man einfach Alle zusammen und schon ist der " + this.getName() + " fertig.");
		anleitung = sb.toString();
		return anleitung;
	}
}
