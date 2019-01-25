package model;

import java.sql.SQLException;
import java.sql.Statement;

public class ScoreQuery extends LaunchDBQuery{
	public ScoreQuery(int level, String name) {
		super(level, name);
	}

	public void setScoreIntoDatabase(Statement statement, int score, int level, String name) throws SQLException {
		statement.executeUpdate("insert into scores values (null, '" + name + "', '" + level + "','" + score + "')");
	}
}
