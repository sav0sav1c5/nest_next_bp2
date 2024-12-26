package rs.ac.uns.ftn.db.jdbc.exam.model;

public class Adresa {

	private int idAdr;
	private String ulicaAdr;
	private int rbrAdr;
	private int gradIdGr;
	
	public Adresa() { 
		super();
	}
	
	public Adresa(int idAdr, String ulicaAdr, int rbrAdr, int gradIdGr) {
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

	public String getUlAdr() {
		return ulicaAdr;
	}

	public void setUlAdr(String ulAdr) {
		this.ulicaAdr = ulAdr;
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

	@Override
	public String toString() {
		return "Adresa [idAdr=" + idAdr + ", ulicaAdr=" + ulicaAdr + ", rbrAdr=" + rbrAdr + ", gradIdGr=" + gradIdGr + "]";
	}
	
	
}
