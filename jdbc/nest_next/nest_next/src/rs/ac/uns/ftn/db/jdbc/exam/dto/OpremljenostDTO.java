package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class OpremljenostDTO {

	private int idOpr;
	private String nivoOpr;
	private String opisOpr;
	
	public OpremljenostDTO(int idOpr, String nivoOpr, String opisOpr) {
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
	
}
