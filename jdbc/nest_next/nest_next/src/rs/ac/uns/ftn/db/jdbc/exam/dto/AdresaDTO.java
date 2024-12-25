package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class AdresaDTO {

	private int idAdr;
	private String ulicaAdr;
	private int rbrAdr;
	private int gradIdGr;
	
	public AdresaDTO(int idAdr, String ulicaAdr, int rbrAdr, int gradIdGr) {
		super();
		this.idAdr = idAdr;
		this.ulicaAdr = ulicaAdr;
		this.rbrAdr = rbrAdr;
		this.gradIdGr = gradIdGr;
	}

	public int getIdAdr() {
		return idAdr;
	}

	public void setIdAdr(int idAdr) {
		this.idAdr = idAdr;
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
