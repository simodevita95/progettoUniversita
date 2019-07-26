package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Connessione;
import model.Docenti;
import model.Studenti;
import model.idao.ICRUDDocenti;

public class CRUDDocenti extends Connessione implements ICRUDDocenti{

	@Override
	public Docenti inserimentoDocenti(Docenti d) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query;
		try {
			conn = connetti();
			query="insert into docente (nome, cognome, insegnamento) value(?,?,?)";
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, d.getNome());
			ps.setString(2, d.getCognome());
			ps.setString(3, d.getInsegnamento());
			int res = ps.executeUpdate();
			if(res>0) {
				rs = ps.getGeneratedKeys();
				rs.next();
				d.setCodDocente(rs.getInt(1));
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
		return d;
	}

	@Override
	public ArrayList<Docenti> listaDocenti() {
		Connection conn = null;
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		String query;
		ArrayList<Docenti> arrayDoc = new ArrayList<Docenti>();
		try {
			conn = connetti();
			query="select * from docente";
			st = conn.createStatement();
			rs=st.executeQuery(query);
				while(rs.next()) {
					Docenti d=new Docenti();
					d.setCodDocente(rs.getInt(1));
					d.setNome(rs.getString(2));
					d.setCognome(rs.getString(3));
					d.setInsegnamento(rs.getString(4));
					arrayDoc.add(d);
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
		return arrayDoc;
	}

	@Override
	public Docenti modificaDocenti(Docenti d) {
		Connection conn = null;
		PreparedStatement ps = null;
		String query;
		try {
			conn = connetti();
			query="update docente set nome=?, cognome=?, insegnamento=? where CodDocente = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, d.getNome());
			ps.setString(2, d.getCognome());
			ps.setString(3, d.getInsegnamento());
			ps.setInt(4, d.getCodDocente());
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
		return d;
	}

	@Override
	public boolean eliminaDocenti(Docenti d) {
		Connection conn = null;
		PreparedStatement ps = null;
		String query;
		boolean eliminato=false;
		try {
			conn = connetti();
			query="delete from docente where CodDocente =?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, d.getCodDocente());
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
	public Docenti ricercaDocenti(Docenti d) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query;
		try {
			conn = connetti();
			query = "select * from docente where CodDocente=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, d.getCodDocente());
			rs = ps.executeQuery();
			if(rs.next()) {
				d = new Docenti();
				d.setCodDocente(rs.getInt(1));
				d.setNome(rs.getString(2));
				d.setCognome(rs.getString(3));
				d.setInsegnamento(rs.getString(4));
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
		return d;
	}

}
