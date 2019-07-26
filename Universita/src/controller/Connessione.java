package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione {
	private static final String Driver="com.mysql.jdbc.Driver";                                                   
	private static final String url ="jdbc:mysql://localhost:3306/universita?useSSL=false";
	private static final String user="root";
	private static final String password="corso";
	public Connection connetti() {
		Connection conn = null;
		try {
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("connessione riuscita");
			
		}catch(ClassNotFoundException e) {
			e.getStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return conn;
		}
		
	}
}
