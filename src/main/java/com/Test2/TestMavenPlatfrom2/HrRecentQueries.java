package com.Test2.TestMavenPlatfrom2;

import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class HrRecentQueries {
	public static void main(String[] strings) {
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://sachin:sachin@cluster0-emxhp.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);

		DB database = mongoClient.getDB("aadarshdb");
		DBCollection more_queries = database.getCollection("more_queries");
		List list = new LinkedList();
		BasicDBObject query = new BasicDBObject();
		DBObject sort = new BasicDBObject("applicationDate", -1);
		DBCursor cursor = more_queries.find().sort(sort);
		
		while (cursor.hasNext()) {
			BasicDBObject obj = (BasicDBObject) cursor.next();
			obj.remove("_id");
			list.add(obj);
			
		}
		System.out.println(list);
	}
}
