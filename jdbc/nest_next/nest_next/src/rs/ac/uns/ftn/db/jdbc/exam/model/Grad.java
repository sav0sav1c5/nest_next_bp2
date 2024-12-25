package rs.ac.uns.ftn.db.jdbc.exam.model;

public class Grad {

	private int idGr;
	private String nazivGr;
	
	public Grad(int idGr, String nazivGr) {
		super();
		this.idGr = idGr;
		this.nazivGr = nazivGr;
	}

    public Grad(String nazivGr) { 
        this.nazivGr = nazivGr;
    }
	
	public int getIdGr() {
		return idGr;
	}

	public void setIdGr(int idGr) {
		this.idGr = idGr;
	}

	public String getNazivGr() {
		return nazivGr;
	}

	public void setNazivGr(String nazivGr) {
		this.nazivGr = nazivGr;
	}

}
