package util;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.DAOException;

public class ConnectionFactory {

	public static Connection getConnection() throws DAOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/TRABALHO_2_POLIESPORTIVA", "javaUser1", "12321@_Senha");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}
	}
	
}
