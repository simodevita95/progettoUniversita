package model;

public class Studenti {
	public Studenti() {
		super();
	}
	public Studenti(String nome, String cognome, String user, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.user = user;
		this.password = password;
	}
	public Studenti(String nome, String cognome, String password, int CodStudente) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.CodStudente = CodStudente;
	}
	private String nome;
	private String cognome;
	private String user;
	private String password;
	private int CodStudente;
	public String getNome() {
		return nome;
	}
	
	public Studenti(int codStudente) {
		super();
		CodStudente = codStudente;
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getCodStudente() {
		return CodStudente;
	}
	public void setCodStudente(int codStudente) {
		CodStudente = codStudente;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
