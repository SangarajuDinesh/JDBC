package com.kn.Crud;

import java.sql.SQLException;
import java.sql.Statement;

public class Update 
{
	public int update(Statement stmt)
	{
		int res=0;
		try {
			res=stmt.executeUpdate("Update bag set brand='American Tourister' where id=2;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
