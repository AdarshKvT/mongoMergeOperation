package com.Test2.Utils;

import java.sql.DatabaseMetaData;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

	public static void main(String[] args) {
		mongonewConn();
		mongooldConn();
		database();
	}

	private static void mongonewConn() {

		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://sachin:sachin@cluster0-emxhp.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
	}

	private static void mongooldConn() {

	}

	public static void database() {
		
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://sachin:sachin@cluster0-emxhp.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("aadarshdb");

	}

}
