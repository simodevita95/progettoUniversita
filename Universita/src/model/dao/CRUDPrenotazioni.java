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
import model.Prenotazioni;
import model.idao.ICRUDPrenotazioni;

public class CRUDPrenotazioni extends Connessione implements ICRUDPrenotazioni {
	Connection conn=null;
	PreparedStatement ps=null;
	String query;
	ResultSet rs=null;

	@Override
	public Prenotazioni prenota(Prenotazioni p) {
		try {
			conn=connetti();
			query="insert into prenotazione(CodStudente,CodEsame)value(?,?)";
			ps=conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,p.getS().getCodStudente());
			ps.setInt(2,p.getE().getCodEsame());
			int res=ps.executeUpdate();
			if(res>0) {
				rs=ps.getGeneratedKeys();
				rs.next();
				p.setIdprenotazione(rs.getInt(3));
			}

		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	@Override
	public ArrayList<Prenotazioni> listaesami(Prenotazioni p) {
		ArrayList<Prenotazioni> arrayP = new ArrayList<Prenotazioni>();

		try {
			conn=connetti();
			query="select esame.CodEsame,prenotazione.CodPrenotazione, esame.dataEsame,docente.CodDocente,docente.nome,docente.cognome,docente.insegnamento from  studente inner join prenotazione on studente.CodStudente =prenotazione.CodStudente inner join esame on prenotazione.CodEsame = esame.CodEsame inner join docente on esame.CodDocente=docente.CodDocente where studente.CodStudente=?";
			ps=conn.prepareStatement(query);
			ps.setInt(1,p.getS().getCodStudente());
			rs=ps.executeQuery();
			while(rs.next()) {
				Esami es= new Esami();
				Docenti d = new Docenti();
				p = new Prenotazioni(es, d);
				es.setCodEsame(rs.getInt(1));
				es.setData(rs.getString(3));
				d.setCodDocente(rs.getInt(4));
				d.setNome(rs.getString(5));
				d.setCognome(rs.getString(6));
				d.setInsegnamento(rs.getString(7));
				p.setIdprenotazione(rs.getInt(2));
				p.setD(d);
				p.setE(es);
				arrayP.add(p);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayP;
	}
	@Override
	public boolean eliminaprenotazione(Prenotazioni p) {
		boolean successo=false;
		try {
			conn=connetti();
			query="delete from prenotazione where CodPrenotazione=?";
			ps=conn.prepareStatement(query);
			ps.setInt(1,p.getIdprenotazione());
			int res=ps.executeUpdate();
			if(res!=0) {
				successo=true;
			}else
			{
				successo=false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				conn.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
		}


		return successo;
	}
}
