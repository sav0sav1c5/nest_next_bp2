package rs.ac.uns.ftn.db.jdbc.exam.model;

public class Stan {
    
	private int idSt;
    private int povrSt;
    private int cenaSt;
    private double ocenaSt;
    private String dostupSt;
    private int adresaIdAdr;
    private int kategorijaIdKat;
    private int opremljenostIdOpr;
    private int stanodavacIdKor;
	
    public Stan() { }
    
    public Stan(int idSt, int povrSt, int cenaSt, double ocena, String dostupSt, int adresaIdAdr, int kategorijaIdKat,
			int opremljenostIdOpr, int stanodavacIdKor) {
		super();
		this.idSt = idSt;
		this.povrSt = povrSt;
		this.cenaSt = cenaSt;
		this.ocenaSt = ocena;
		this.dostupSt = dostupSt;
		this.adresaIdAdr = adresaIdAdr;
		this.kategorijaIdKat = kategorijaIdKat;
		this.opremljenostIdOpr = opremljenostIdOpr;
		this.stanodavacIdKor = stanodavacIdKor;
	}

	public int getIdSt() {
		return idSt;
	}

	public void setIdSt(int idSt) {
		this.idSt = idSt;
	}

	public int getPovrSt() {
		return povrSt;
	}

	public void setPovrSt(int povrSt) {
		this.povrSt = povrSt;
	}

	public int getCenaSt() {
		return cenaSt;
	}

	public void setCenaSt(int cenaSt) {
		this.cenaSt = cenaSt;
	}

	public double getOcenaSt() {
		return ocenaSt;
	}

	public void setOcenaSt(double ocenaSt) {
		this.ocenaSt = ocenaSt;
	}

	public String getDostupSt() {
		return dostupSt;
	}

	public void setDostupSt(String dostupSt) {
		this.dostupSt = dostupSt;
	}

	public int getAdresaIdAdr() {
		return adresaIdAdr;
	}

	public void setAdresaIdAdr(int adresaIdAdr) {
		this.adresaIdAdr = adresaIdAdr;
	}

	public int getKategorijaIdKat() {
		return kategorijaIdKat;
	}

	public void setKategorijaIdKat(int kategorijaIdKat) {
		this.kategorijaIdKat = kategorijaIdKat;
	}

	public int getOpremljenostIdOpr() {
		return opremljenostIdOpr;
	}

	public void setOpremljenostIdOpr(int opremljenostIdOpr) {
		this.opremljenostIdOpr = opremljenostIdOpr;
	}

	public int getStanodavacIdKor() {
		return stanodavacIdKor;
	}

	public void setStanodavacIdKor(int stanodavacIdKor) {
		this.stanodavacIdKor = stanodavacIdKor;
	}

	@Override
	public String toString() {
		return "Stan [idSt=" + idSt + ", povrSt=" + povrSt + ", cenaSt=" + cenaSt + ", ocenaSt=" + ocenaSt
				+ ", dostupSt=" + dostupSt + ", adresaIdAdr=" + adresaIdAdr + ", kategorijaIdKat=" + kategorijaIdKat
				+ ", opremljenostIdOpr=" + opremljenostIdOpr + ", stanodavacIdKor=" + stanodavacIdKor + "]";
	}
    
}
