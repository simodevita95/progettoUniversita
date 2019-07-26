package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Connessione;
import model.Amministratori;
import model.idao.IDaoAmministratore;

public class DaoAmministratore extends Connessione implements IDaoAmministratore {
	@Override
	public Amministratori loginAdmin(String username, String password) {
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		Amministratori adm = null;
		String query;
		try {
			conn=connetti();
			query="select * from amministratore where user=? and password=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()) {
				if(username!=null && password!=null) {
					adm = new Amministratori();
					adm.setCodAdmin(rs.getInt(1));
					adm.setNome(rs.getString(2));
					adm.setCognome(rs.getString(3));
					adm.setUser(rs.getString(4));
					adm.setPassword(rs.getString(5));
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
		return adm;
	}
}
