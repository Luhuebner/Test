package compared;

import java.util.Comparator;

import arten.Getraenk;

public class NameAufComparator implements Comparator<Getraenk>{
// Vergleich vom Namen zweier Objekte
	@Override
	public int compare(Getraenk o1, Getraenk o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
