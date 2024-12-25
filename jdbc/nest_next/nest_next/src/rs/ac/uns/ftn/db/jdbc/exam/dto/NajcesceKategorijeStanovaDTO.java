package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class NajcesceKategorijeStanovaDTO {

    private String nazivGr;
    private String nazivKat;
    private int brojStanova;
	
    public NajcesceKategorijeStanovaDTO(String nazivGr, String nazivKat, int brojStanova) {
		super();
		this.nazivGr = nazivGr;
		this.nazivKat = nazivKat;
		this.brojStanova = brojStanova;
	}

	public String getNazivGr() {
		return nazivGr;
	}

	public void setNazivGr(String nazivGr) {
		this.nazivGr = nazivGr;
	}

	public String getNazivKat() {
		return nazivKat;
	}

	public void setNazivKat(String nazivKat) {
		this.nazivKat = nazivKat;
	}

	public int getBrojStanova() {
		return brojStanova;
	}

	public void setBrojStanova(int brojStanova) {
		this.brojStanova = brojStanova;
	}

	@Override
	public String toString() {
		return String.format("%-20s | %-15s | %d", nazivGr, nazivKat, brojStanova);
	}
    
}
