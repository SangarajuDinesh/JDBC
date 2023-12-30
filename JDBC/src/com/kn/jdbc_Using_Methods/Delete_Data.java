package com.kn.jdbc_Using_Methods;

import java.sql.SQLException;
import java.sql.Statement;

public class Delete_Data
{
	public int delete(Statement s)
	{
		int rows=0;
		try {
			rows=s.executeUpdate("Delete from doctor where id= 1 and 2 and 3 ;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
}
