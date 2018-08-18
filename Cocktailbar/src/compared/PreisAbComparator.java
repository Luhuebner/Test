package compared;

import java.util.Comparator;

import arten.Einzelgetraenk;
import arten.Getraenk;

public class PreisAbComparator implements Comparator<Getraenk>{
// Vergleich vom Preis zweier Objekte
	@Override
	public int compare(Getraenk o1, Getraenk o2) {
		if(o1.getPreis()> o2.getPreis()) return -1;
		if(o1.getPreis()< o2.getPreis()) return 1;
		return 0;
	}

}
