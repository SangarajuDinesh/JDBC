package com.kn.jdbc_Using_Methods;

import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table 
{
	public void create(Statement s)
	{
		try {
			s.execute("CREATE TABLE DOCTOR (ID INT, NAME VARCHAR(20), EXPERIENCE INT);");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
