package com.kn.Jdbc.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionDemo
{
	public static void main(String[] args) 
	{
		String URL="jdbc:mysql://localhost:3306/hospital";
		String USER="root";
		String PASSWORD="Dk966653@";
		//String CREATE_TABLE="CREATE TABLE PATIENT(ID INT, NAME VARCHAR(20), DISEASE VARCHAR(20));";
		//String INSERT_DATA="INSERT INTO PATIENT VALUES (2,'DINESH','DENGUE'),(3,'SURESH','COLD');";
		//String UPDATE_DATA="UPDATE PATIENT SET NAME='KUMAR' WHERE NAME='MAHESH';";
		String DELETE_DATA="DELETE FROM PATIENT WHERE ID=3;";
		try {
			//1. Load Driver and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//FQCN(Fully Qualified Class Name) - Canonical Name
			System.out.println("Class Loaded and Registered..");
			//2. Establish the Connection with Database
			Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection Established Successfully "+con);
			//3. Create a Statement Object
			 Statement stmt= con.createStatement();
			//4. Send and Execute the Query
			//stmt.execute(CREATE_TABLE);
			 System.out.println("Table is Created");
			//int rows=stmt.executeUpdate(INSERT_DATA);
			//int rows=stmt.executeUpdate(UPDATE_DATA);
			 int rows=stmt.executeUpdate(DELETE_DATA);
			System.out.println(rows+" are affected..");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Failed to Establish the Connection");
			e.printStackTrace();
		}
	}
}
