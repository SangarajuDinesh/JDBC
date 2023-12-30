package com.kn.Crud;

import java.sql.SQLException;
import java.sql.Statement;

public class Insert 
{
	public void insert(Statement stmt)
	{
		try {
			stmt.execute("Insert into bag values (1,'Wrogn',700),(2,'Reebok',600);");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
