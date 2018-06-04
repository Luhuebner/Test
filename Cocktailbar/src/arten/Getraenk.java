package arten;

public abstract class Getraenk {
	private String name;
	private double kalorien; // in kcal / 100gramm

	
	public Getraenk(String name, double kcal) {
		this.name = name;
		this.kalorien = kcal;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public double getKalorien() {
		return kalorien;
	}

	public void setKalorien(double kcal) {
		kalorien = kcal;
	}
}
