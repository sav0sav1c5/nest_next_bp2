package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class OpremljenostDTO {

	private String nivoOpr;
	private String opisOpr;
	
	public OpremljenostDTO() {
		super();
	}

	public OpremljenostDTO(String nivoOpr, String opisOpr) {
		super();
		this.nivoOpr = nivoOpr;
		this.opisOpr = opisOpr;
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
