package com.srccode.clas;

import java.sql.Connection;
import java.sql.DriverManager;

import com.srccode.interfaces.ConnectMySQL;

public class MySQLConnection implements ConnectMySQL {
	@Override
	public Connection connection() {
		try {
			PropertySingleton propertySingleton = new PropertySingleton();
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(propertySingleton.sqlUrl, propertySingleton.sqlUser,
					propertySingleton.sqlPassword);
		} catch (Throwable e) {
			System.out.print("Connection Error: ");
			e.printStackTrace();
			return null;
		}
	}
}
