package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.swing.JOptionPane;

public class ScoreTracker
{

	private User user;
	private int currentScore;
	private int highestScore;
	private String gameID;
	
	public ScoreTracker(User inUser) 
	{
		this.user = inUser;
		currentScore = 0;
		highestScore=getHighestScore();
		this.gameID = UUID.randomUUID().toString();
		
	}


	public void recordScore(int point)
	{
		int scoreType;
		
		if(point == -1){
			scoreType = 0;
			this.currentScore--;
		}
		else{
			scoreType = 1;
			this.currentScore++;
		}
		
		DbUtilities db = new DbUtilities();
		
		String sql = "INSERT INTO runningscores(`gameID`,`scoreType`,`scoreValue`,`fk_userID`,`dateTimeEntered`)";
		sql = sql + "VALUES('" + gameID + "'," + scoreType + "," + this.getCurrentScore() + "," + user.getUserID() + ",NOW());";
		
		db.executeQuery(sql);
		db.closeConnection();
	}
	
	public void recordFinalScore()
	{
		DbUtilities db = new DbUtilities();
		
		String sql = "INSERT INTO finalscores (gameID,scoreValue,fk_userId,dateTimeEntered)";
		sql = sql +"VALUES('" + gameID +"'," + this.getCurrentScore() + "," + user.getUserID() + ",NOW());";
		
		db.executeQuery(sql);
		db.closeConnection();
	}
	
	
	public void finalMessage()
	{
		DbUtilities db = new DbUtilities();
		String bestPlayer=null;
		
		

		
		String sql = "SELECT lastName, firstName, MAX(scoreValue) FROM finalscores JOIN users ON fk_userID = userID GROUP BY lastName, firstName ORDER BY `MAX(scoreValue)` DESC;";

		ResultSet res = db.getResultSet(sql);
		try {
				res.next();
				String fName = res.getString("firstName");
				String lName = res.getString("lastName");
				int highestScoreEver = res.getInt("MAX(scoreValue)");
				bestPlayer = fName+" " + lName + " With a top score of " + highestScoreEver ;
			 
			
		}catch(SQLException e){
			
		}
		
		sql = "SELECT MAX(scoreValue) FROM finalscores WHERE fk_userID = " + user.getUserID() + ";";		
		ResultSet rs = db.getResultSet(sql);
		try {
				rs.next();
				highestScore = rs.getInt("MAX(scoreValue)");
			
		} catch (SQLException e) {
			
		}

		db.closeConnection();
		
		String s = "Current Score " + currentScore + "\nYour highest score is " + highestScore +"\nThe best player ever is " + bestPlayer;
		
		JOptionPane.showMessageDialog(null, s);
	}
	
	

	public String getGameID() {
		return gameID;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
		
	}
	
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	
	
	
	
}
