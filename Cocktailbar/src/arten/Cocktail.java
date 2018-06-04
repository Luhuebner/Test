package arten;

import java.util.Vector;

public class Cocktail {
	private String name;
	private Vector v;
	private double kalorien = 0.00;
	
	public Cocktail(String name, Getraenk [] g1) {
		v = new Vector();
		this.setName(name);
		for(int i = 0;i<g1.length;i++) {
			v.addElement(g1[i]);
			this.kalorien = this.kalorien + g1[i].getKalorien();
		}
		this.kalorien = this.kalorien / g1.length;
		
	}

	public double getKalorien() {
		return kalorien;
	}

	public void setKalorien(double kalorien) {
		this.kalorien = kalorien;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
