package compared;

import java.util.Comparator;

import arten.Getraenk;

public class NameAufComparator implements Comparator<Getraenk>{

	@Override
	public int compare(Getraenk o1, Getraenk o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
