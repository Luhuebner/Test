package arten;

import java.util.Vector;

public class Cocktail extends Getraenk{
	private Vector v;
	private double kalorien;
	
	public Cocktail(String name, Einzelgetraenk [] g1) {
		super(name);
		
		v = new Vector();
		for(int i = 0;i<g1.length;i++) {
			v.addElement(g1[i]);
			kalorien = kalorien + g1[i].getKalorien();
		}
		kalorien = kalorien / g1.length;
			
		
	}

	public double getKalorien() {
		return kalorien;
	}

	public void setKalorien(double kalorien) {
		this.kalorien = kalorien;
	}
	
	
}
