package model;

public class Amministratori {
	private String nome;
	private String cognome;
	private String user;
	private String password;
	private int CodAdmin;
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCodAdmin() {
		return CodAdmin;
	}
	public void setCodAdmin(int codAdmin) {
		CodAdmin = codAdmin;
	}
}
