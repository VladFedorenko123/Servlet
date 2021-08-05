package com.srccode.clas;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.srccode.interfaces.ConnectMongo;

public class MongoDBConnection implements ConnectMongo {
	@Override
	public String connection() {
		PropertySingleton propertySingleton = new PropertySingleton();

		MongoClient mongo = new MongoClient(propertySingleton.mongoUrl, Integer.parseInt(propertySingleton.mongoPort));
		MongoDatabase db = mongo.getDatabase(propertySingleton.mongoDatabase);
		MongoCollection<Document> collection = db.getCollection(propertySingleton.mongoCollection);

		String text = collection.find().first().getString("str");

		mongo.close();
		return text;
	}
}
