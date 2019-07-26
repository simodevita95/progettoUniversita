package model;

public class Docenti {
	
	public Docenti(int codDocente) {
		super();
		CodDocente = codDocente;
	}
	public Docenti(String nome, String cognome, String insegnamento, int codDocente) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.insegnamento = insegnamento;
		CodDocente = codDocente;
	}
	public Docenti() {
		super();
	}
	public Docenti(String nome, String cognome, String insegnamento) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.insegnamento = insegnamento;
	}
	private String nome;
	private String cognome;
	private String insegnamento;
	private int CodDocente;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getInsegnamento() {
		return insegnamento;
	}
	public void setInsegnamento(String insegnamento) {
		this.insegnamento = insegnamento;
	}
	public int getCodDocente() {
		return CodDocente;
	}
	public void setCodDocente(int codDocente) {
		CodDocente = codDocente;
	}	
}
