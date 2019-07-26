package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Connessione;
import model.Amministratori;
import model.Studenti;
import model.idao.ICRUDStudenti;

public class CRUDStudenti extends Connessione implements ICRUDStudenti{

	@Override
	public Studenti inserimentoStud(Studenti s) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query;
		try {	
			if(s.getNome()!="") {
				conn = connetti();
				query="insert into studente (nome, cognome, user, password) value(?,?,?,?)";
				ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, s.getNome());
				ps.setString(2, s.getCognome());
				ps.setString(3, s.getUser());
				ps.setString(4, s.getPassword());
				int res = ps.executeUpdate();
				if(res>0) {
					rs = ps.getGeneratedKeys();
					rs.next();
					s.setCodStudente(rs.getInt(1));
				}
			}
		}catch(Exception e) {

		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		return s;
	}

	@Override
	public ArrayList<Studenti> listaStud() {
		Connection conn = null;
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		String query;
		ArrayList<Studenti> arrayStud = new ArrayList<Studenti>();
		try {
			conn = connetti();
			query="select * from studente";
			st = conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				Studenti s= new Studenti();
				s.setCodStudente(rs.getInt(1));
				s.setNome(rs.getString(2));
				s.setCognome(rs.getString(3));
				s.setUser(rs.getString(4));
				s.setPassword(rs.getString(5));
				arrayStud.add(s);
			}
		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayStud;
	}

	@Override
	public Studenti modificaStud(Studenti s) {
		Connection conn = null;
		PreparedStatement ps = null;
		String query;
		try {
			conn = connetti();
			query="update studente set nome=?, cognome=?, password=? where CodStudente = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, s.getNome());
			ps.setString(2, s.getCognome());
			ps.setString(3, s.getPassword());
			ps.setInt(4, s.getCodStudente());
			ps.executeUpdate();
		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		return s;
	}

	@Override
	public boolean eliminaStud(Studenti s) {
		Connection conn = null;
		PreparedStatement ps = null;
		String query;
		boolean eliminato=false;
		try {
			conn = connetti();
			query="delete from studente where CodStudente =?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, s.getCodStudente());
			int res=ps.executeUpdate();
			if(res!=0) {
				eliminato=true;
			}else {
				eliminato=false;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		return eliminato;
	}

	@Override
	public Studenti ricercaStud(Studenti s) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query;
		try {
			conn = connetti();
			query = "select * from studente where CodStudente=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, s.getCodStudente());
			rs = ps.executeQuery();
			if(rs.next()) {
				s = new Studenti();
				s.setCodStudente(rs.getInt(1));
				s.setNome(rs.getString(2));
				s.setCognome(rs.getString(3));
				s.setUser(rs.getString(4));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		return s;
	}

	@Override
	public Studenti loginStudenti(String username, String password) {
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		Studenti s = null;
		String query;
		try {
			conn=connetti();
			query="select * from studente where user=? and password=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()) {
				if(username!=null && password!=null) {
					s = new Studenti();
					s.setCodStudente(rs.getInt(1));
					s.setNome((rs.getString(2)));
					s.setCognome(rs.getString(3));
					s.setUser(rs.getString(4));
					s.setPassword(rs.getString(5));
				}
			}
		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s;
	}

}
