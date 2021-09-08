package com.mahendra;

import java.sql.*;


public class Main1 {

	//Database connection string 
	// Syntax ::> jdbc:[DBPRODUCTNAME]:[DBHOST]:[PORT]/[DBNAME]
	// Oracle XE ::> jdbc:oracle:thin:@localhost:1521/xe
	private static final String URL="jdbc:mysql://sample-db.centralindia.azurecontainer.io:3306/hr";
	
	// Username & Password
	private static final String USER = "mahendra";
	private static final String PASSWORD = "pass@1234";
		
	public static void main(String[] args) {
		
		try {
			// Manually Loading a Class from reference library!
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			System.out.println("Error "+ce.getMessage());
			return; // Quit the application
		}
		
		// try-with-resource would CLOSE the connection object
		try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD)) 
		{
			System.out.println("Connected !");
			PreparedStatement ps = con.prepareStatement("select emp_no, first_name, last_name, gender, hire_date, birth_date from employees");
			ResultSet rs = ps.executeQuery();
			System.out.println("EMPNO    FIRST_NAME   LAST_NAME   ");
			while(rs.next()) {
				System.out.println(""+rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5)+rs.getString(6));
			}
		}catch(SQLException ex) {
			System.out.println("Error: "+ex.getMessage());
			return;
		}
		
			
	}

}
