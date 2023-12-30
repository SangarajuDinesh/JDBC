package com.kn.jdbc_Using_Methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select
{
	public ResultSet select(Statement s)
	{
		ResultSet set=null;
		try {
			set = s.executeQuery("Select * from patient;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;
	}
}
