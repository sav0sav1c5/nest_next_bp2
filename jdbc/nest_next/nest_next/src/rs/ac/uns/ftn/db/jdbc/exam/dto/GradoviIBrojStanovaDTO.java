package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class GradoviIBrojStanovaDTO {

	private String nazivGr;
	private int brojSt;
	
	public GradoviIBrojStanovaDTO() {
		super();
	}

	public GradoviIBrojStanovaDTO(String nazivGr, int brojSt) {
		super();
		this.nazivGr = nazivGr;
		this.brojSt = brojSt;
	}

	public String getNazivGr() {
		return nazivGr;
	}

	public void setNazivGr(String nazivGr) {
		this.nazivGr = nazivGr;
	}

	public int getBrojSt() {
		return brojSt;
	}

	public void setBrojSt(int brojSt) {
		this.brojSt = brojSt;
	}
	
	public static String getFormattedHeader() {
		
		StringBuilder formattedHeader = new StringBuilder();
		formattedHeader.append(" _____________________________________________\n");
		formattedHeader.append(String.format("| %-5s | %-20s | %-10s | %n", "Br.", "Grad", "Broj Stanova"));
		formattedHeader.append(" ---------------------------------------------");
        
        return formattedHeader.toString();
	}

	@Override
	public String toString() {
		
	    StringBuilder formatted = new StringBuilder();
	    formatted.append(String.format("| %-20s | %-10d   | %n", getNazivGr(), getBrojSt()));
		formatted.append(" ---------------------------------------------");
        
        return formatted.toString();
	}
}
