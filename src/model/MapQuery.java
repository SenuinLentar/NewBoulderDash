package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import model.modelInterface.IMapQuery;

public class MapQuery extends LaunchDBQuery implements IMapQuery {

	/**
	 * Constructor of MapQuery
	 * 
	 * @param level
	 */
	public MapQuery(int level, String name) {
		super(level, name);
	}

	/**
	 * Execute a static SQL request
	 * 
	 */
	public ResultSet executeMapQuery(ResultSet result, Statement statement) {
		try {
			switch (level) {
			case 1:
				result = statement.executeQuery("call `procédure_LV1`");
				break;
			case 2:
				result = statement.executeQuery("call `procédure_LV2`");
				break;
			case 3:
				result = statement.executeQuery("call `procédure_LV3`");
				break;
			case 4:
				result = statement.executeQuery("call `procédure_LV4`");
				break;
			case 5:
				result = statement.executeQuery("call `procédure_LV5`");
				break;
			default:
				System.out.print("System error");
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IDAOTest#setQueryIntoTable()
	 */
	public void setMapQueryIntoTable(ResultSet result, char[][] tab) {
		try {
			int ligne = 0;
			while (result.next()) {
				for (int colonne = 0; colonne < result.getObject(2).toString().length(); colonne++) {
					tab[ligne][colonne] = result.getObject(2).toString().charAt(colonne);
				}
				ligne++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setMapQueryIntoTable(int level, char[][] tab) throws FileNotFoundException {
		String filePath;
		switch (level) {
		case 1:
			filePath = "image/lvUN.txt";
			break;
		case 2:
			filePath = "image/lvDEUX.txt";
			break;
		case 3:
			filePath = "image/lvTROIS.txt";
			break;
		case 4:
			filePath = "image/lvQUATRE.txt";
			break;
		case 5:
			filePath = "image/lvCINQ.txt";
			break;
		default:
			System.out.print("System error");
			filePath = "image/test.txt";
			break;
		}
		
		Scanner scan = new Scanner(new File(filePath));
		int ligne = 0;
		String line;
		char[] charLine;
		while (scan.hasNext()) {
			line = scan.next();
			charLine = line.toCharArray();
			for (int colonne = 0; colonne < line.length(); colonne++) {
				tab[ligne][colonne] = charLine[colonne];
			}
			ligne++;
		}
		scan.close();
	}
}
