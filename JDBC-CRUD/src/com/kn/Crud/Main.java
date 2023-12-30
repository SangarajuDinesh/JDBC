package com.kn.Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main 
{
	private static final String url="jdbc:mysql://localhost:3306/hibernate"; 
	private static final String user="root"; 
	private static final String password="Dk966653@"; 
	public static void main(String[] args)
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection(url, user, password);
			Statement stmt= con.createStatement();
//			Create ct=new Create();
//			ct.create(stmt);
//			System.out.println("Created.....");
//			Insert inst=new Insert();
//			inst.insert(stmt);
//			System.out.println("Inserted..");
//			Update up=new Update();
//			int rows=up.update(stmt);
//			System.out.println(rows+" rows are effected...");
			Delete del=new Delete();
			int row=del.delete(stmt);
			System.out.println(row+" are effected...");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
