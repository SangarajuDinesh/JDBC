package com.kn.Select_Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_Query
{
	public static final String URL="jdbc:mysql://localhost:3306/hospital";
	public static final String User="root";
	public static final String Password="Dk966653@";
	public static final String select="select * from patient;";
	public static void main(String[] args)
	{
		Connection con=null;
		try {
			//1.load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded and Registered");
			//2. Establish the connection
			con=DriverManager.getConnection(URL, User, Password);
			//3. Create Statement object
			Statement stmt=con.createStatement();
			//4. Send and Execute queries
			ResultSet set=stmt.executeQuery(select);
			//5. Process Data from result set
			while(set.next())
			{
				System.out.println("Id = "+set.getInt(1)+" Name = "+set.getString(2)+" Disease = "+set.getString(3));	
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
				{
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
