package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Connessione;
import model.Docenti;
import model.Esami;
import model.Studenti;
import model.idao.ICRUDEsami;

public class CRUDEsami extends Connessione implements ICRUDEsami{

	@Override
	public Esami inserimentoEsami(Esami es) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query;
		try {
			conn = connetti();
			query="insert into esame (dataEsame, CodDocente) value(?,?)";
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, es.getData());
			ps.setInt(2, es.getD().getCodDocente());
			int res = ps.executeUpdate();
			if(res>0) {
				rs = ps.getGeneratedKeys();
				rs.next();
				es.setCodEsame((rs.getInt(1)));
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
		return es;

	}

	@Override
	public ArrayList<Esami> listaEsami(Docenti d, String data, int codEsame) {
		Connection conn = null;
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		String query;
		ArrayList<Esami> arrayE = new ArrayList<Esami>();
		try {
			conn = connetti();
			query="select * from esame inner join docente on esame.codDocente=docente.codDocente";
			st = conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				d = new Docenti();
				Esami e=new Esami();
				e.setCodEsame(rs.getInt(1));
				e.setData(rs.getString(2));
				d.setCodDocente(rs.getInt(3));
				d.setNome(rs.getString(5));
				d.setCognome(rs.getString(6));
				d.setInsegnamento(rs.getString(7));
				e.setD(d);
				arrayE.add(e);
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
		return arrayE;
	}

	@Override
	public boolean modificaEsami(Esami es) {
		Connection conn = null;
		PreparedStatement ps = null;
		String query;
		boolean successo=false;
		int res = 0;
		try {
			conn = connetti();
			query="update esame set dataEsame=?,CodDocente=? where CodEsame = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(3, es.getCodEsame());
			ps.setString(1,es.getData());
			ps.setInt(2, es.getD().getCodDocente());
			res=ps.executeUpdate();
			if(res!=0) {
				successo=true;
			}else
			{
				successo=false;
			}
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
		return successo;
	}

	@Override
	public boolean eliminaEsami(Esami es) {
		Connection conn = null;
		PreparedStatement ps = null;
		String query;
		boolean eliminato=false;
		try {
			conn = connetti();
			query="delete from esame where CodEsame =?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, es.getCodEsame());
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
	public Esami ricercaEsami(Esami es) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query;
		try {
			conn = connetti();
			query = "select * from esame where CodEsame=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, es.getCodEsame());
			rs = ps.executeQuery();
			if(rs.next()) {
				Docenti d=new Docenti();
				es.setCodEsame(rs.getInt(1));
				es.setData(rs.getString(2));
				es.setD(d);
				d.setCodDocente(rs.getInt(3));
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
		return es;
	}

}
