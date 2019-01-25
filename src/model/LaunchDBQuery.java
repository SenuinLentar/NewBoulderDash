package model;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchDBQuery {
	protected int level = 0, finalDiamonds = 1;
	protected char tab[][] = new char[22][40];
	protected String name = "";
	protected DAOConnector connectionBDD;
	protected MapQuery mapQuery;
	protected DiamondQuery diamondQuery;
	protected ScoreQuery ScoreQuery;
	protected Statement statement = null;
	protected ResultSet result;
	
	/**
	 * Constructor of LaunchDBQuery
	 * 
	 * @param level
	 */
	public LaunchDBQuery(int level, String name){
		this.level = level;
		this.name = name;
	}
	
	/**
	 * Contains all the query we need to execute
	 * @throws FileNotFoundException 
	 */
	public void launchQueries() throws FileNotFoundException{
//		connectionBDD = new DAOConnector(level, name);
//		connectionBDD.connection();
		
		mapQuery = new MapQuery(level, name);
		//result = mapQuery.executeMapQuery(result, statement);
		//mapQuery.setMapQueryIntoTable(result, tab);
		mapQuery.setMapQueryIntoTable(level, tab);

//		diamondQuery = new DiamondQuery(level, name);
//		try {
//			result = diamondQuery.executeDiamondQuery(result, statement);
//			diamondQuery.setQueryDiamondsInToInteger(result);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	public void launchScoreQuery(int score){
		connectionBDD = new DAOConnector(level, name);
		connectionBDD.connection();
		
		ScoreQuery = new ScoreQuery(level, name);
		try {
			ScoreQuery.setScoreIntoDatabase(statement, score, level, name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Getters of tab
	 * 
	 * @return tab
	 */
	public char[][] getTab() {
		return tab;
	}
	
	/**
	 * Getters of finalDiamonds
	 * 
	 * @return finalDiamonds
	 */
	public int getFinalDiamonds() {
		return finalDiamonds;
	}
}
