package com.kn.UserEntry_Using_WildCardCharacters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserEnterData_Into_Table
{
	public static final String Url="jdbc:mysql://localhost:3306/hospital";
	public static final String User="root";
	public static final String Password="Dk966653@";
	public static final String insert="insert into patient values (?,?,?);";
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the id = ");
		int id=sc.nextInt();
		System.out.print("Enter the Name = ");
		String Name=sc.next();
		System.out.print("Enter the Disease = ");
		String Disease=sc.next();
		Connection con=null;
		try {
			//1. Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded & Registered");
			//2. Establish the Connection
			con=DriverManager.getConnection(Url, User, Password);
			System.out.println("Connection Established..");
			//3. Create a Prepare Statement
			PreparedStatement ps=con.prepareStatement(insert);
			//4. Send and Execute Queries
			ps.setInt(1, id);
			ps.setString(2, Name);
			ps.setString(3, Disease);
			ps.execute();
		} catch (ClassNotFoundException e) 
		{
			System.out.println("Driver not Found..");
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
		sc.close();
	}
}
