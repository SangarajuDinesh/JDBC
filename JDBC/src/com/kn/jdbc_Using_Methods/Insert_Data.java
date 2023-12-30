package com.kn.jdbc_Using_Methods;

import java.sql.SQLException;
import java.sql.Statement;

public class Insert_Data
{
	public int insert(Statement s)
	{
		int rows=0;
		try {
			rows=s.executeUpdate("Insert into doctor values (1,'Dinesh',2),(2,'Suresh',3);");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
}
