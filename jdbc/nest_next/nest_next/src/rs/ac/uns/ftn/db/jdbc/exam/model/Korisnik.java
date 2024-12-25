package rs.ac.uns.ftn.db.jdbc.exam.model;

public class Korisnik {

	private int idKor;
	private String imeKor;
	private String prezimeKor;
	private String emailKor;
	private String tipKor;
	
	public Korisnik(int idKor, String imeKor, String prezimeKor, String emailKor, String tipKor) {
		super();
		this.idKor = idKor;
		this.imeKor = imeKor;
		this.prezimeKor = prezimeKor;
		this.emailKor = emailKor;
		this.tipKor = tipKor;
	}

	public int getIdKor() {
		return idKor;
	}

	public void setIdKor(int idKor) {
		this.idKor = idKor;
	}

	public String getImeKor() {
		return imeKor;
	}

	public void setImeKor(String imeKor) {
		this.imeKor = imeKor;
	}

	public String getPrezimeKor() {
		return prezimeKor;
	}

	public void setPrezimeKor(String prezimeKor) {
		this.prezimeKor = prezimeKor;
	}

	public String getEmailKor() {
		return emailKor;
	}

	public void setEmailKor(String emailKor) {
		this.emailKor = emailKor;
	}

	public String getTipKor() {
		return tipKor;
	}

	public void setTipKor(String tipKor) {
		this.tipKor = tipKor;
	}

	@Override
	public String toString() {
		return "Korisnik [idKor=" + idKor + ", imeKor=" + imeKor + ", prezimeKor=" + prezimeKor + ", emailKor="
				+ emailKor + ", tipKor=" + tipKor + "]";
	}
	
}
