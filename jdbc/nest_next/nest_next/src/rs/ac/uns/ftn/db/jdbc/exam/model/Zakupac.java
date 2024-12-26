package rs.ac.uns.ftn.db.jdbc.exam.model;

public class Zakupac extends Korisnik {

	private String prefZak;
	
	public Zakupac(int idKor, String imeKor, String prezimeKor, String emailKor, String tipKor, String prefZak) {
		super(idKor, imeKor, prezimeKor, emailKor, tipKor);
		this.prefZak = prefZak;
	}

	public String getPrefZak() {
		return prefZak;
	}

	public void setPrefZak(String prefZak) {
		this.prefZak = prefZak;
	}

}
