package rs.ac.uns.ftn.db.jdbc.exam.model;

public class Stanodavac extends Korisnik {

	private double ocenaStanod;
	
	public Stanodavac(double ocenaStanod) {
		super();
		this.ocenaStanod = ocenaStanod;
	}
	
	public Stanodavac(int idKor, String imeKor, String prezimeKor, String emailKor, String tipKor, double ocenaStanod) {
		super(idKor, imeKor, prezimeKor, emailKor, tipKor);
		this.ocenaStanod = ocenaStanod;
	}

	public double getOcenaStanod() {
		return ocenaStanod;
	}

	public void setOcenaStanod(double ocenaStanod) {
		this.ocenaStanod = ocenaStanod;
	}
	
}
