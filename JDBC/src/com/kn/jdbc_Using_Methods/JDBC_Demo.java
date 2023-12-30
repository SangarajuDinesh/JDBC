package com.kn.jdbc_Using_Methods;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBC_Demo
{
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/hospital";
		String user="root";
		String password="Dk966653@";
//		Create_Table ct=new Create_Table();
//		Insert_Data id=new Insert_Data();
//		Update_Data ud=new Update_Data();
//		Delete_Data dd=new Delete_Data();
		Select s=new Select();
		Connection con=null;
		try {
			//1. Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Establish Connection between Java and Database
			con=DriverManager.getConnection(url, user, password);
			//3. Create Statment object
			Statement itr = con.createStatement();
			
//			ct.create(itr);
//			System.out.println("Table is Created succesfully");
//			
//			int rows=id.insert(itr);
//			int rows=ud.update(itr);
//			int rows=dd.delete(itr);
//			System.out.println(rows+" are effected..");
			ResultSet set=s.select(itr);
			while(set.next())
			{
				System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getString(3));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection failed");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
