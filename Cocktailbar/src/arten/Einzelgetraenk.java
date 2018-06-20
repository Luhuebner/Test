package arten;

public class Einzelgetraenk extends Getraenk {
	protected double lagergehalt;
	
	
	public Einzelgetraenk(String name, double kcal, double alkgehalt, double preis) {
		super(name,kcal,alkgehalt, preis);
		this.lagergehalt = 150000;
		
	}
	public void erhoeheLagergehalt(double wert) {
		this.setLagergehalt(this.getLagergehalt()+wert);
	}

	public double getLagergehalt() {
		return lagergehalt;
	}

	public void setLagergehalt(double lagergehalt) {
		this.lagergehalt = lagergehalt;
	}
}
