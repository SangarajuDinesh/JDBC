package com.kn.jdbc_Using_Methods;

import java.sql.SQLException;
import java.sql.Statement;

public class Update_Data
{
	public int update(Statement s)
	{
		int rows=0;
		try {
			rows=s.executeUpdate("update doctor set name='manesh' where name='dinesh';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
}
