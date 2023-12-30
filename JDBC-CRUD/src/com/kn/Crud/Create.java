package com.kn.Crud;

import java.sql.SQLException;
import java.sql.Statement;

public class Create 
{
	public void create(Statement stmt)
	{
		try {
			stmt.execute("create table Bag ( id int, brand varchar(20), cost int );");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
