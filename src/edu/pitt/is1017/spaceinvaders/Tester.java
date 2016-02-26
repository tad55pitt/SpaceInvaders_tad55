package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Tester {

	
	String gameID;
	
	
	public static void main(String[] args) 
	{
		DbUtilities db = new DbUtilities();
		
		String firstName="troy";
		String lastName="dinkel";
		//String email="tad55@pitt.edu";
		//String password="swish";
		
		//String sql = "INSERT INTO users (lastName,firstName,email,password) ";
		//sql = sql + "VALUES('" + lastName + "','" + firstName + "','" + email + "',MD5('" + password + "'));";

		//db.executeQuery(sql);
		
		//System.out.print(sql);
		//hardcoded, but we need to get them from input fields
		String email = "tad55@pitt.edu";
		String password = "swish";
		
		
		//String sql = "SELECT * FROM users WHERE email = '"+email+"' AND password = MD5('"+password+"');";
		//System.out.print(sql);
		/*
		try{
			ResultSet rs = db.getResultSet(sql);
			if(rs.next()){
				System.out.println("TRUE");
			}
			else{
				System.out.println("FALSE");
			}
			db.closeConnection();
			}catch(SQLException e){
				
			}
		*/
		
		/*
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				System.out.print(rs.getString("firstName")+" ");
				System.out.print(rs.getString("lastName")+" ");
				System.out.print(rs.getString("email")+" ");
			}
			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//String sql3 = "UPDATE users SET firstName ='" + firstName + "' lastName='" + lastName + 
			//	"' email='" + email + "' password= MD5('" + password +"');";
		//System.out.println(sql3);
		
		UUID u = UUID.randomUUID();
		String gameID = u.toString();
		System.out.println(gameID);
		String highestScore="100";
		
		//String sql = "SELECT scoreValue from finalscores WHERE user = "+t.user.getUserID()+";";
		//System.out.print(sql);
	}

}
