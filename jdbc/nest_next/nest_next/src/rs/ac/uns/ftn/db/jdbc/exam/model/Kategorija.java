package rs.ac.uns.ftn.db.jdbc.exam.model;

public class Kategorija {
	
	private int idKat;
	private String nazivKat;
	
	public Kategorija(int idKat, String nazivKat) {
		super();
		this.idKat = idKat;
		this.nazivKat = nazivKat;
	}
	
	public int getIdKat() {
		return idKat;
	}
	
	public void setIdKat(int idKat) {
		this.idKat = idKat;
	}
	
	public String getNazivKat() {
		return nazivKat;
	}
	
	public void setNazivKat(String nazivKat) {
		this.nazivKat = nazivKat;
	}
	
	@Override
	public String toString() {
		return "Kategorija [idKat=" + idKat + ", nazivKat=" + nazivKat + "]";
	}
	
}
