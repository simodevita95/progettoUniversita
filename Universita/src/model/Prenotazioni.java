package model;

public class Prenotazioni {
	public Prenotazioni(Esami e, Docenti d) {
		super();
		this.e = e;
		this.d = d;
	}

	public Docenti getD() {
		return d;
	}

	public void setD(Docenti d) {
		this.d = d;
	}

	Studenti s;
	Esami e;
	Docenti d;
	private int idprenotazione;

	public int getIdprenotazione() {
		return idprenotazione;
	}

	public void setIdprenotazione(int idprenotazione) {
		this.idprenotazione = idprenotazione;
	}

	public Prenotazioni(Studenti s,Esami e) {
		super();
		this.s=s;
		this.e = e;
	}

	public Prenotazioni() {
		super();
	}

	public Studenti getS() {
		return s;
	}

	public void setS(Studenti s) {
		this.s = s;
	}

	public Esami getE() {
		return e;
	}

	public void setE(Esami e) {
		this.e = e;
	}


}
