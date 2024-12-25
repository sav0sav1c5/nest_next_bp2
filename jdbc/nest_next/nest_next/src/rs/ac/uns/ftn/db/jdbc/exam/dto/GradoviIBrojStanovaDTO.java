package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class GradoviIBrojStanovaDTO {

	private String nazivGr;
	private int brojSt;
	
	public GradoviIBrojStanovaDTO(String nazivGr, int brojSt) {
		super();
		this.nazivGr = nazivGr;
		this.brojSt = brojSt;
	}

	public String getNazivGr() {
		return nazivGr;
	}

	public void setNazivGr(String nazivGr) {
		this.nazivGr = nazivGr;
	}

	public int getBrojSt() {
		return brojSt;
	}

	public void setBrojSt(int brojSt) {
		this.brojSt = brojSt;
	}

}
