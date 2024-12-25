package rs.ac.uns.ftn.db.jdbc.exam.model;

public class Prostorija {

    private int idPros;
    private String nazPros;
    private double povrPros;
    private int stanIdSt;
	
    public Prostorija(int idPros, String nazPros, double povrPros, int stanIdSt) {
		super();
		this.idPros = idPros;
		this.nazPros = nazPros;
		this.povrPros = povrPros;
		this.stanIdSt = stanIdSt;
	}

	public int getIdPros() {
		return idPros;
	}

	public void setIdPros(int idPros) {
		this.idPros = idPros;
	}

	public String getNazPros() {
		return nazPros;
	}

	public void setNazPros(String nazPros) {
		this.nazPros = nazPros;
	}

	public double getPovrPros() {
		return povrPros;
	}

	public void setPovrPros(double povrPros) {
		this.povrPros = povrPros;
	}

	public int getStanIdSt() {
		return stanIdSt;
	}

	public void setStanIdSt(int stanIdSt) {
		this.stanIdSt = stanIdSt;
	}

	@Override
	public String toString() {
		return "Prostorija [idPros=" + idPros + ", nazPros=" + nazPros + ", povrPros=" + povrPros + ", stanIdSt="
				+ stanIdSt + "]";
	}
	
}
