package arten;

public abstract class Getraenk {
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
