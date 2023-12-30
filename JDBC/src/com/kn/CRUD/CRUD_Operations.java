package com.kn.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD_Operations
{
	private static final String URL="jdbc:mysql://localhost:3306/hospital";
	private static final String USER="root";
	private static final String PASSWORD = "Dk966653@";
	private static final String insert="INSERT INTO PATIENT VALUES (?,?,?);";
	private static final String select="SELECT * FROM PATIENT;";
	private static final String update="UPDATE PATIENT SET DISEASE = ? WHERE ID = ? ;";
	private static final String delete="DELETE FROM PATIENT WHERE ID = ? ;";
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose the Option to Perform...");
		System.out.println("1. Insert Data");
		System.out.println("2. Read Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		System.out.println("5. Quit ");
		int option=sc.nextInt();
		Connection con=null;
		try {
			//1. Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Establish the Connection
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			switch(option)
			{
			case 1:
				insert(con,sc);
				break;
			case 2:
				read(con,sc);
				break;
			case 3:
				update(con,sc);
				break;
			case 4:
				delete(con,sc);
				break;
			case 5:
				quit(con);
				break;
			default:
				System.out.println("Thank you...");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
	private static void quit(Connection con)
	{
		try {
			if(con!=null)
			{
				con.close();
				System.out.println("Connection closed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void delete(Connection con, Scanner sc)
	{
		System.out.println("Enter the ID = ");
		int id=sc.nextInt();
		try {
			PreparedStatement pstmt=con.prepareStatement(delete);
			ResultSet set=pstmt.executeQuery(select);
			System.out.println("Before Delete the records");
			while(set.next())
			{
				System.out.println(" Id = "+set.getInt(1)+" , Name = "+set.getString(2)+" , Disease = "+set.getString(3));
			}
			pstmt.setInt(1, id);
			int rows =pstmt.executeUpdate();
			System.out.println(rows+" rows are effected");
			ResultSet set1=pstmt.executeQuery(select);
			System.out.println("After Delete the records");
			while(set1.next())
			{
				System.out.println(" Id = "+set1.getInt(1)+" , Name = "+set1.getString(2)+" , Disease = "+set1.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void update(Connection con, Scanner sc)
	{
		System.out.println("Enter the ID = ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Disease = ");
		String disease=sc.nextLine();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(update);
			ResultSet set = pstmt.executeQuery(select);
			while(set.next())
			{
				System.out.println(" Id = "+set.getInt(1)+" , Name = "+set.getString(2)+" , Disease = "+set.getString(3));
			}
			pstmt.setInt(1, id);
			pstmt.setString(3, disease);
			int rows=pstmt.executeUpdate();
			System.out.println(rows+" are effected ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void read(Connection con, Scanner sc)
	{
		try {
			PreparedStatement pstmt=con.prepareStatement(select);
			ResultSet set =pstmt.executeQuery(select);
			while(set.next())
			{
				System.out.println(" Id = "+set.getInt(1)+" , Name = "+set.getString(2)+" , Disease = "+set.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void insert(Connection con, Scanner sc)
	{
		System.out.println("Enter the Id = ");
		int id=sc.nextInt();
		System.out.println("Enter the Name = ");
		String name = sc.next();
		System.out.println("Enter the Disease = ");
		String disease = sc.next();

		try {
			PreparedStatement pstmt= con.prepareStatement(insert);
			ResultSet set = pstmt.executeQuery(select);
			System.out.println("Data Before Inserting .....");
			while(set.next())
			{
				System.out.println(" Id = "+set.getInt(1)+" , Name = "+set.getString(2)+" , Disease = "+set.getString(3));
			}
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, disease);
			pstmt.execute();
			System.out.println("Data after Inserting....");
			ResultSet set1 = pstmt.executeQuery(select);
			while(set1.next())
			{
				System.out.println(" Id = "+set1.getInt(1)+" , Name = "+set1.getString(2)+" , Disease = "+set1.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
