package model;

public class Esami {

	public Esami(int codEsame) {
		super();
		CodEsame = codEsame;
	}
	public Esami(String data, int codEsame) {
		super();
		this.data = data;
		CodEsame = codEsame;
	}
	public Esami() {
		super();
	}
	public Esami(Docenti d, String data) {
		super();
		this.d = d;
		this.data = data;
	}
	private Docenti d;
	public Docenti getD() {
		return d;
	}
	public void setD(Docenti d) {
		this.d = d;
	}
	private String data;
	private int CodEsame;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getCodEsame() {
		return CodEsame;
	}
	public void setCodEsame(int codEsame) {
		CodEsame = codEsame;
	}
	public Esami(Docenti d, String data, int codEsame) {
		super();
		this.d = d;
		this.data = data;
		CodEsame = codEsame;
	}
	public Esami(Docenti d, int codEsame) {
		super();
		this.d = d;
		CodEsame = codEsame;
	}

}