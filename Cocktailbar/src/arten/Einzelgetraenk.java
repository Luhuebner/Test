package arten;

public class Einzelgetraenk extends Getraenk {
	private double lagergehalt;
	
	public Einzelgetraenk(String name, double kcal, double alkgehalt) {
		super(name,kcal,alkgehalt);
		this.setLagergehalt(150000 + Math.round(Math.random()*50000));
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
