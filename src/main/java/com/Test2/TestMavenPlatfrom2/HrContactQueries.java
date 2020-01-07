package com.Test2.TestMavenPlatfrom2;

import javax.swing.plaf.basic.BasicBorders;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class HrContactQueries {
	public static void main(String[] args) {
//		JSONObject params = json.getJSONObject("params");
//		JSONObject querystring = params.getJSONObject("querystring");
//		String searchText = querystring.getString("searchText");

		String searchText = "aarti@acc.ltd";
		JSONObject response = new JSONObject();
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://sachin:sachin@cluster0-emxhp.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("aadarshdb");
		MongoCollection<Document> more_queries = database.getCollection("more_queries");
		MongoCollection<Document> user_details = database.getCollection("user_details");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("$text", new BasicDBObject("$search", "\"" + searchText + "\""));
		JSONObject eachData = new JSONObject();
		JSONArray jsonArray = new JSONArray();

//		// search query in user_Details
//		FindIterable<Document> iterableDoc = more_queries.find(searchQuery);
//		if (iterableDoc != null) {
//			for (Document doc : iterableDoc) {
//				doc.remove("_id");
//				jsonArray.put(doc);
//			}
//			eachData.put("data", jsonArray);
//			System.out.println("jsonArray" + jsonArray);
//		} else {
//			System.out.println("Data not found!!");
//		}
//
//		// search query in user_Details
//		FindIterable<Document> iterableDoc2 = more_queries.find(searchQuery);
//		if (iterableDoc != null) {
//			for (Document doc : iterableDoc) {
//				doc.remove("_id");
//				jsonArray.put(doc);
//			}
//			eachData.put("", jsonArray);
//			System.out.println("jsonArray" + jsonArray);
//		} else {
//			System.out.println("Data not found!!");
//		}
//		response.remove("_id");
//		response.put("data", jsonArray);
//		System.out.println("final array:--->>" + response);

//		JSONArray morearray = new JSONArray();
//		FindIterable<Document> docs = more_queries.find(searchQuery);
//		if (docs != null) {
//
//			// search query in more_queries
//			for (Document doc : docs) {
//				morearray.put(doc);
//			}
//			if (morearray != null && !(morearray.equals(""))) {
//				response.remove("_id");
//				System.out.println("morearray" +morearray);
//				response.put("data", morearray);
//				response.put("message", "text search successfully");
//				response.put("statusCode", 200);
//			} else {
//				response.put("message", "Data not found");
//				response.put("statusCode", 200);
//			}

		// search query in user_data
		JSONArray user_detArray = new JSONArray();
		FindIterable<Document> user_detailsdocs = user_details.find(searchQuery);
		// search query in user_details
		for (Document doc : user_detailsdocs) {
			user_detArray.put(doc);
		}
		if (user_detArray != null && !(user_detArray.equals(""))) {
			System.out.println("user_detArray" + user_detArray);
			
			response.put("data", user_detArray);
			response.put("message", "text search successfully");
			response.put("statusCode", 200);
		} else {
			response.put("message", "Data not found");
			response.put("statusCode", 200);
		}
	}

}

//		JSONObject response = new JSONObject();
//		JSONArray array = new JSONArray();
//		FindIterable<Document> docs = user_details.find(searchQuery);
//		if (docs != null) {
//			for (Document doc : docs) {
//				array.put(doc);
//			}
//			if (array != null && !(array.equals(""))) {
//				System.out.println(array);
//				System.out.println("text search successfully");
//
//			} else {
//				System.out.println("Data not found");
//
//			}
//
//		}
