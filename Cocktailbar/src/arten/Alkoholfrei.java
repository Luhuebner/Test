package arten;

public abstract class Alkoholfrei extends Einzelgetraenk{
	private double alkgehalt;

	public Alkoholfrei(String name, double kcal) {
		super(name, kcal);
		this.alkgehalt = 0.00;
	}

	public double getAlkgehalt() {
		return alkgehalt;
	}

	public void setAlkgehalt(double alkgehalt) {
		this.alkgehalt = alkgehalt;
	}

}
