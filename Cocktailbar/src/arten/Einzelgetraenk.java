package arten;

public class Einzelgetraenk extends Getraenk {
	private double kalorien; // in kcal / 100gramm

	public Einzelgetraenk(String name, double kcal) {
		super(name);
		this.kalorien = kcal;
	}

	public double getKalorien() {
		return kalorien;
	}

	public void setKalorien(double kalorien) {
		this.kalorien = kalorien;
	}

}
