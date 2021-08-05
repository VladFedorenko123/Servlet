package com.srccode.clas;

import java.sql.ResultSet;

import java.sql.Statement;

import com.srccode.interfaces.ConnectMySQL;
import com.srccode.interfaces.Reader;

public class MySQLTextReader implements Reader {
	ConnectMySQL con = new MySQLConnection();

	@Override
	public String getText() {
		try {
			Statement statement = con.connection().createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
			String myText = null;
			while (resultSet.next()) {
				String text1 = resultSet.getString(2);
				myText = text1;
			}
			return myText;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
