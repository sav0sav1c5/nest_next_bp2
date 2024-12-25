package rs.ac.uns.ftn.db.jdbc.exam.dto;

import rs.ac.uns.ftn.db.jdbc.exam.model.Adresa;
import rs.ac.uns.ftn.db.jdbc.exam.model.Stan;

public class OglasavanjeDTO {

	private Adresa adresa;
	private Stan stan;
	
	public OglasavanjeDTO(Adresa adresa, Stan stan) {
		super();
		this.adresa = adresa;
		this.stan = stan;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Stan getStan() {
		return stan;
	}

	public void setStan(Stan stan) {
		this.stan = stan;
	}
	
	
}
