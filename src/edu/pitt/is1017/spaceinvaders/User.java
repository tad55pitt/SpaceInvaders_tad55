package edu.pitt.is1017.spaceinvaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class User 
{

	private int userID;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	boolean loggedIn = false;



	public static void main(String[] args)
	{

	}

	public User(int userID)
	{
		DbUtilities db = new DbUtilities();

		String sql = "SELECT * FROM users WHERE userID="+userID+";";
		ResultSet rs = db.getResultSet(sql);
		try {
			int id=rs.getInt("userID");
			String firstName=rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String email = rs.getString("email");
			String password = rs.getString("password");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.password=password;

		db.closeConnection();
	}

	public User(String email,String password)
	{
		loggedIn=false;
		DbUtilities db = new DbUtilities();

		String sql = "SELECT * FROM users WHERE email = '"+email+"' AND password = MD5('"+password+"');";
		
		try{
			ResultSet rs = db.getResultSet(sql);
			if(rs.next()){
				this.loggedIn = true;
				userID=rs.getInt("userID");
				firstName=rs.getString("firstName");
				lastName = rs.getString("lastName");
				email = rs.getString("email");
				password = rs.getString("password");
				JOptionPane.showMessageDialog(null, "Login Successful");
				
			}
			else{
				System.out.println("FALSE");
				this.loggedIn = false;	
				JOptionPane.showMessageDialog(null, "Invalid email or password");

			}
			db.closeConnection();
		}catch(SQLException e){

		}
	}


	public User(String lastName, String firstName,String email,String password)
	{
		DbUtilities db = new DbUtilities();

		String sql = "INSERT INTO users (lastName,firstName,email,password) ";
		sql = sql + "VALUES('" + lastName + "','" + firstName + "','" + email + "',MD5('" + password + "'));";

		db.executeQuery(sql);
	}

	public void saveUserInfo()
	{
		DbUtilities db = new DbUtilities();

		String sql = "UPDATE users SET firstName ='" + this.firstName + "' lastName='" + this.lastName + 
				"' email='" + this.email + "' password= MD5('" + this.password +"');";

		db.executeQuery(sql);
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public int getUserID() {
		return userID;
	}



}//ends class
