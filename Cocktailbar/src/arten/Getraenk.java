package arten;

import java.io.Serializable;

public abstract class Getraenk implements Serializable {
	protected String name;
	protected double kalorien; // in kcal / 100gramm
	protected double alkgehalt;
	protected double preis;
		
	// Konstruktor Getraenk
	public Getraenk(String name, double kcal, double alkgehalt, double preis) {
		this.name = name;
		this.kalorien = kcal;
		this.alkgehalt = alkgehalt;
		this.preis = preis;
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

	public void setKalorien(double kalorien) {
		this.kalorien = kalorien;
	}
	
	public double getAlkgehalt() {
		return alkgehalt;
	}

	public void setAlkgehalt(double alkgehalt) {
		this.alkgehalt = alkgehalt;
	}
	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
}
