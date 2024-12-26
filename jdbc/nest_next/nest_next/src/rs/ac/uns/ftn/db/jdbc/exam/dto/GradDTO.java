package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class GradDTO {

	private String nazivGr;
	
	public GradDTO() {
		super();
	}

	public GradDTO(String nazivGr) {
		super();
		this.nazivGr = nazivGr;
	}

	public String getNazivGr() {
		return nazivGr;
	}

	public void setNazivGr(String nazivGr) {
		this.nazivGr = nazivGr;
	}
	
	public static String getFormattedHeader() {
        StringBuilder formattedHeader = new StringBuilder();
        formattedHeader.append(" ______________________________\n");
        formattedHeader.append(String.format("| %-5s | %-20s | %n", "Br.", "Grad"));
        formattedHeader.append(" ------------------------------");
        return formattedHeader.toString();
	}
	
	@Override
	public String toString() {
	    StringBuilder formatted = new StringBuilder();
	    formatted.append(String.format("| %-20s | %n", getNazivGr()));
	    formatted.append(" ------------------------------");
	    return formatted.toString();
	}

}
