package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class AdresaDTO {

	private String ulicaAdr;
	private int rbrAdr;
	private int gradIdGr;
	
	public AdresaDTO() {
		super();
	}

	public AdresaDTO(String ulicaAdr, int rbrAdr, int gradIdGr) {
		super();
		this.ulicaAdr = ulicaAdr;
		this.rbrAdr = rbrAdr;
		this.gradIdGr = gradIdGr;
	}

	public String getUlicaAdr() {
		return ulicaAdr;
	}

	public void setUlicaAdr(String ulicaAdr) {
		this.ulicaAdr = ulicaAdr;
	}

	public int getRbrAdr() {
		return rbrAdr;
	}

	public void setRbrAdr(int rbrAdr) {
		this.rbrAdr = rbrAdr;
	}

	public int getGradIdGr() {
		return gradIdGr;
	}

	public void setGradIdGr(int gradIdGr) {
		this.gradIdGr = gradIdGr;
	}
	
}
