package crud;

import java.beans.Statement;
import java.sql.ResultSet;

public class Select {

	public static void main(String[] args) {
		

	}

	public void Connection () {
		String sql = "SELECT * FROM Users";
		 
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		 
		int count = 0;
		 
		while (result.next()){
		    String name = result.getString(2);
		    String pass = result.getString(3);
		    String fullname = result.getString("fullname");
		    String email = result.getString("email");
		 
		    String output = "User #%d: %s - %s - %s - %s";
		    System.out.println(String.format(output, ++count, name, pass, fullname, email));
		}
	}
	
	public void PreparedStatement() {
		
	}
	
	public void ResultSet() {
		
	}
	
}
