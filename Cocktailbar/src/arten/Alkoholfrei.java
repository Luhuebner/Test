package arten;

public abstract class Alkoholfrei extends Einzelgetraenk{
	
	public Alkoholfrei(String name, double kcal, double preis) {
		super(name, kcal, 0, preis);	
	}
}
