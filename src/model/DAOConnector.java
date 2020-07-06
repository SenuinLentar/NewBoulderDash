package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.modelInterface.IDAOConnector;

public class DAOConnector extends LaunchDBQuery implements IDAOConnector {
	private final String URL = "jdbc:mysql://163.172.137.110:3306/boulderdash";
	private final String LOGIN = "boulderdashUser";
	private final String PASSWORD = "&MIHeju8a6537yERuH8tuyECi68CeSo1";
	
//	private final String URL = "jdbc:mysql://localhost:3306/boulderdash";
//	private final String LOGIN = "root";
//	private final String PASSWORD = "maxime";
	
	private int choice = 0;
	
	/**
	 * Constructor of DAOConnector
	 * 
	 * @param level
	 */
	public DAOConnector(int level, String name) {
		super(level, name);
	}

	/**
	 * Connection to the remote database
	 */
	public void connection() {
		
		try {
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			statement = connection.createStatement();
			
			connection.close();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see model.IDAOTest#getChoice()
	 */
	public int getChoice() {
		return choice;
	}

	/* (non-Javadoc)
	 * @see model.IDAOConnector#getStatement()
	 */
	public Statement getStatement() {
		return statement;
	}

	/* (non-Javadoc)
	 * @see model.IDAOConnector#getResult()
	 */
	public ResultSet getResult() {
		return result;
	}

}