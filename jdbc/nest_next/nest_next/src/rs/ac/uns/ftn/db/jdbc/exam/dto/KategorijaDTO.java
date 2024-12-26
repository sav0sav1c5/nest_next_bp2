package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class KategorijaDTO {

	private String nazivKat;
	private int brStanovaUKat;
	private double prosCenaStanaUKat;
	
	public KategorijaDTO() {
		super();
	}

	public KategorijaDTO(String nazivKat, int brStanovaUKat) {
		super();
		this.nazivKat = nazivKat;
		this.brStanovaUKat = brStanovaUKat;
	}

	public KategorijaDTO(String nazivKat, double prosCenaStanaUKat) {
		super();
		this.nazivKat = nazivKat;
		this.prosCenaStanaUKat = prosCenaStanaUKat;
	}
	
	public KategorijaDTO(String nazivKat, int brStanovaUKat, double prosCenaStanaUKat) {
		super();
		this.nazivKat = nazivKat;
		this.brStanovaUKat = brStanovaUKat;
		this.prosCenaStanaUKat = prosCenaStanaUKat;
	}
	
	public String getNazivKat() {
		return nazivKat;
	}

	public void setNazivKat(String nazivKat) {
		this.nazivKat = nazivKat;
	}

	public int getBrStanovaUKat() {
		return brStanovaUKat;
	}

	public void setBrStanovaUKat(int brStanovaUKat) {
		this.brStanovaUKat = brStanovaUKat;
	}

	public double getProsCenaStanaUKat() {
		return prosCenaStanaUKat;
	}

	public void setProsCenaStanaUKat(double prosCenaStanaUKat) {
		this.prosCenaStanaUKat = prosCenaStanaUKat;
	}
	
	public static String getFormattedHeader() {
		
		StringBuilder formattedHeader = new StringBuilder();
		formattedHeader.append(" _________________________________________\n");
		formattedHeader.append(String.format("| %-5s | %-15s | %-10s | %n", "Br.", "Kategorija", "Prosečna Cena"));
		formattedHeader.append(" -----------------------------------------");
        
        return formattedHeader.toString();
	}

	@Override
	public String toString() {
		
		StringBuilder formatted = new StringBuilder();
		formatted.append(String.format("| %-15s | %-10.2f    | %n", getNazivKat(), getProsCenaStanaUKat()));
		formatted.append(" -----------------------------------------");
        
        return formatted.toString();
	}
	
}
