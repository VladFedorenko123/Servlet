package com.srccode.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.mongodb.client.MongoClient;

class MongoDBConnectionTest {
	MongoClient mongo = Mockito.mock(MongoClient.class);

	@Test
	void testConnection() {
		assertNotNull(mongo);
	}

}
