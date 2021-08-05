package com.srccode.test;

import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MySQLConnectionTest {
	Connection mockConnection = Mockito.mock(Connection.class);
	Statement statement = Mockito.mock(Statement.class);

	@Test
	void testConnection() {
		try {
			when(mockConnection.createStatement()).thenReturn(statement);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
