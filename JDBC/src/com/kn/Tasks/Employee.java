package com.kn.Tasks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Employee
{
	private static final String url="jdbc:mysql://localhost:3306/university";
	private static final String User="root";
	private static final String password="Dk966653@";
	private static final String update="update employee set salary=salary+(10/100)*salary where id=?; ";
	public static void main(String[] args)
	
	{
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		try {
			//1.Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Establish the Connection
			con=DriverManager.getConnection(url, User, password);
			//3. Create Prepared Statement
			PreparedStatement stmt= con.prepareStatement(update);
			System.out.println("Enter the Emp_id = ");
			int id=sc.nextInt();
			stmt.setInt(1, id);
			int rows=stmt.executeUpdate();
			System.out.println(rows+" rows are effected");
			ResultSet set=stmt.executeQuery("Select * from employee;");
			while(set.next())
			{
				System.out.println("Id = "+set.getInt(1)+" , Name = "+set.getString(2)+" , Salary = "+set.getInt(3));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//5. close the Connection
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
		sc.close();
	}
}
