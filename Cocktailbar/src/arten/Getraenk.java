package arten;

import java.io.Serializable;

public abstract class Getraenk implements Serializable {
	private String name;
	

	
	public Getraenk(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
