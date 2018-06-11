package arten;

public class Alkoholisch extends Einzelgetraenk{
	private double alkgehalt;
	
	public Alkoholisch(String name, double kcal, double alk) {
		super(name, kcal);
		this.alkgehalt = alk;
	}

	public double getAlkgehalt() {
		return alkgehalt;
	}

	public void setAlkgehalt(double alkgehalt) {
		this.alkgehalt = alkgehalt;
	}

}
