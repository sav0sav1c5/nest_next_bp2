package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class NajcesceKategorijeStanovaDTO {

    private String nazivGr;
    private String nazivKat;
    private int brojStanova;
	
    public NajcesceKategorijeStanovaDTO() {
		super();
	}

	public NajcesceKategorijeStanovaDTO(String nazivGr, String nazivKat, int brojStanova) {
		super();
		this.nazivGr = nazivGr;
		this.nazivKat = nazivKat;
		this.brojStanova = brojStanova;
	}

	public String getNazivGr() {
		return nazivGr;
	}

	public void setNazivGr(String nazivGr) {
		this.nazivGr = nazivGr;
	}

	public String getNazivKat() {
		return nazivKat;
	}

	public void setNazivKat(String nazivKat) {
		this.nazivKat = nazivKat;
	}

	public int getBrojStanova() {
		return brojStanova;
	}

	public void setBrojStanova(int brojStanova) {
		this.brojStanova = brojStanova;
	}

	public static String getFormattedHeader() {
		
	    StringBuilder formattedHeader = new StringBuilder();
	    formattedHeader.append(" ________________________________________________________________________________________________\n");
	    formattedHeader.append(String.format("| %-5s | %-20s | %-45s                   | %n", "Br.", "Grad", "Kategorije i broj stanova"));
	    formattedHeader.append(" ------------------------------------------------------------------------------------------------");
	    
		return formattedHeader.toString();
	}
	
	@Override
	public String toString() {

		StringBuilder formatted = new StringBuilder();
	    formatted.append(String.format("| %-20s | %-25s | %-15d | %n", getNazivGr(), getNazivKat(), getBrojStanova()));
	    formatted.append(" ------------------------------------------------------------------------------------------------");
		
		return formatted.toString();
	}

	
}
