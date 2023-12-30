package com.kn.Batch_Processing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch_Processing 
{
	private static final String Url="jdbc:mysql://localhost:3306/hospital";
	private static final String User="root";
	private static final String Password="Dk966653@";
	private static final String insert="insert into patient values (2,'Dhoni','Knee_Injure'),(3,'Raina','Mental');";
	private static final String update="Update patient set name='jadeja' where name='Dhoni';";
	private static final String delete="delete from patient where name = 'jadeja' or name='Raina';";
	private static final String select="select * from patient;";
	public static void main(String[] args)
	{
		Connection con=null;
		try {
			//1. Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Establish the Connection
			con = DriverManager.getConnection(Url,User,Password);
			//3. Create Statement
			Statement stmt = con.createStatement();
			con.setAutoCommit(false);
			stmt.addBatch(insert);
			stmt.addBatch(update);
			stmt.addBatch(delete);
			int arr[]=stmt.executeBatch();
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			ResultSet set=stmt.executeQuery(select);
			while(set.next())
			{
				System.out.println(" ID = "+set.getInt(1)+" , Name = "+set.getString(2)+" , Disease = "+set.getString(3));
			}
			con.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
