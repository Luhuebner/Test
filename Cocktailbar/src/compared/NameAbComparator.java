package compared;

import java.util.Comparator;

import arten.Getraenk;

public class NameAbComparator implements Comparator<Getraenk>{
// Vergleich vom Namen zweier Objekte
	@Override
	public int compare(Getraenk o1, Getraenk o2) {
		// TODO Auto-generated method stub
		return o2.getName().compareTo(o1.getName());
	}

}
