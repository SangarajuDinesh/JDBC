package com.kn.Crud;

import java.sql.SQLException;
import java.sql.Statement;

public class Delete
{
	public int delete(Statement stmt)
	{
		int res=0;
		try {
			res=stmt.executeUpdate("delete from bag where id=2;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
