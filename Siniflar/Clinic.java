package Siniflar;

public class Clinic {
	
	private int id;
	private String isim;
	
	public Clinic(int id, String isim) {
		super();
		this.id = id;
		this.isim = isim;
	}
	
	public Clinic( ) {
	 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}
	
	

}
