package arten;

public class Einzelgetraenk extends Getraenk {
	protected double lagergehalt;
	
	// Konstruktor Einzelgetraenk
	public Einzelgetraenk(String name, double kcal, double alkgehalt, double preis) {
		super(name,kcal,alkgehalt, preis);
		this.lagergehalt = 150000;
		
	}
	// Lagergehalt erhöhen
	public void erhoeheLagergehalt(double wert) {
		this.setLagergehalt(this.getLagergehalt()+wert);
	}
	// getter Lagergehalt
	public double getLagergehalt() {
		return lagergehalt;
	}
	/ setter Lagergehalt
	public void setLagergehalt(double lagergehalt) {
		this.lagergehalt = lagergehalt;
	}
}
