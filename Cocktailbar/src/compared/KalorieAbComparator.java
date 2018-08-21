package compared;

import java.util.Comparator;

import arten.Einzelgetraenk;
import arten.Getraenk;

public class KalorieAbComparator implements Comparator<Getraenk>{
// Vergleich vom Kaloriengehalt zweier Objekte
	@Override
	public int compare(Getraenk o1, Getraenk o2) {
		if(o1.getKalorien()< o2.getKalorien()) return -1;
		if(o1.getKalorien()> o2.getKalorien()) return 1;
		return 0;
	}

}
