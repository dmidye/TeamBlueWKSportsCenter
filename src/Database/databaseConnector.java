package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//This class when created allows for connections to a mysql database
public class databaseConnector {
	
	Connection con;
	String path;
	String username;
	String password;
	
	public databaseConnector() {
		path = "jdbc:mysql://localhost:3306/wk_sports_center_db";
		username = "root";
		password = "";
		
		try {
		Class.forName("com.mysql.jdbc.Driver");  //Retrieve driver class
		con=DriverManager.getConnection(path,username,password); 
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public databaseConnector(String path, String username, String password) {
		this.path = path;
		this.username = username;
		this.password = password;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  //Retrieve driver class
			con=DriverManager.getConnection(path,username,password); 
			}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//Create a select statement, send the statement, and return it's resultSet.
	public ResultSet sendStatement(String query) {
		ResultSet rs = null;
	
		try {
			Statement stmt=con.createStatement();  
			System.out.println(query);
			rs =stmt.executeQuery(query);  //Send query to server
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return rs;
	}
	
	public int sendUpdate(String query) {
		int rs = -200;
		
		try {
			Statement stmt=con.createStatement();  
			System.out.println(query);
			rs =stmt.executeUpdate(query);  //Send query to server
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return rs;
	}
	
	
	//Call to disconnect from the database
	public void disconnectFromDatabase() {
		try {
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
