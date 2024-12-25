package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class KategorijaDTO {

	private int idKat;
	private String nazivKat;
	
	public KategorijaDTO(int idKat, String nazivKat) {
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
	
}
