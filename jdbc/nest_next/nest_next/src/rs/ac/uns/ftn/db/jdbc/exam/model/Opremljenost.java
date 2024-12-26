package rs.ac.uns.ftn.db.jdbc.exam.model;

public class Opremljenost {
	
	private int idOpr;
	private String nivoOpr;
	private String opisOpr;
	
	public Opremljenost() {
		super();
	}

	public Opremljenost(int idOpr, String nivoOpr, String opisOpr) {
		super();
		this.idOpr = idOpr;
		this.nivoOpr = nivoOpr;
		this.opisOpr = opisOpr;
	}

	public int getIdOpr() {
		return idOpr;
	}

	public void setIdOpr(int idOpr) {
		this.idOpr = idOpr;
	}

	public String getNivoOpr() {
		return nivoOpr;
	}

	public void setNivoOpr(String nivoOpr) {
		this.nivoOpr = nivoOpr;
	}

	public String getOpisOpr() {
		return opisOpr;
	}

	public void setOpisOpr(String opisOpr) {
		this.opisOpr = opisOpr;
	}

	@Override
	public String toString() {
		return "Opremljenost [idOpr=" + idOpr + ", nivoOpr=" + nivoOpr + ", opisOpr=" + opisOpr + "]";
	}
	
}
