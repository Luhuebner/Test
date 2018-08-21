package compared;

import java.util.Comparator;

import arten.Einzelgetraenk;
import arten.Getraenk;

public class AlkAufComparator implements Comparator<Getraenk>{
// Vergleich vom Alkoholgehalt zweier Objekte
	@Override
	public int compare(Getraenk o1, Getraenk o2) {
		if(o1.getAlkgehalt()< o2.getAlkgehalt()) return -1;
		if(o1.getAlkgehalt()> o2.getAlkgehalt()) return 1;
		return 0;
	}

}
