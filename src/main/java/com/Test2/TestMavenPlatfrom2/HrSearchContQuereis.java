package com.Test2.TestMavenPlatfrom2;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class HrSearchContQuereis {

	public static void main(String[] args) {
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://sachin:sachin@cluster0-emxhp.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("aadarshdb");
		MongoCollection<Document> more_queries = database.getCollection("more_queries");
		MongoCollection<Document> user_details = database.getCollection("user_details");

		// db.collection1.find().forEach(function(doc){db.collection2.save(doc)})

		String searchtext = "+91 9632395400";
		
		// Creating the iterator to looping through documents
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("$text", new BasicDBObject("$search", "\"" + searchtext + "\""));
	    searchQuery.put("moreQueryStatus", "completed");

		// search query in user_details
		JSONArray userArray = new JSONArray();
		List<Document> user_detailsm = (List<Document>) user_details.find((Bson) searchQuery)
                .into(new ArrayList<Document>());
		
	//	FindIterable<Document> userdocs = user_details.find(searchQuery);
		for (Document doc : user_detailsm) {
			doc.remove("_id");
			doc.remove("isLinkedIn");
			doc.remove("designation");
			doc.remove("dashboard");
			userArray.put(doc);
		}
		if (userArray != null && !(userArray.equals(""))) {
			System.out.println("data" + userArray);

		} else {
			System.out.println("Data not found");
		}
		mongoClient.close();

	}
}


//			Object jsonInput;
//			JsonNode root = objectMapper.readTree(jsonInput);
//			return root.get("data").get("data2").get("value").asText();
//			JSONArray jsonArray = new JSONArray();
//			for (int index = 0; index < more_queriesList.size(); index++) {
//			moreQueriesArray.get(index).toString();
//			}
//			
//			FindIterable<Document> iterableDoc = more_queries.find(searchQuery);
//			if (iterableDoc != null) {
//				for (Document doc : iterableDoc) {
//					jsonArray.put(jsonArray);
//				}
//				System.out.println("jsonArray..." + jsonArray);
//			} else {
//				System.out.println("Data not found!!");
//			}

//				boolean found = false;
//				Object searchText = "jobId";
//				System.out.println("before if-->>");
//				for (int i = 0; i > moreQueriesArray.length(); i++)
//					if (moreQueriesArray.getString(9).equals(searchText)) {
//						System.out.println("found");
//					} else {
//						System.out.println("not found");
//					}
//				found = true;

//				// initialize array
//				String[] arr=new String[moreQueriesArray.length()];
//			    for(int i=0; i<arr.length; i++) {
//			        arr[i]=moreQueriesArray.optString(i);
//			    }
//			    System.out.println("arr---------->" +arr);
//				
//				String searchText = "aarti";
//				BasicDBObject searchQuery = new BasicDBObject();
//				searchQuery.append("$text", new BasicDBObject("$search", "\"" + searchText + "\""));
//				String searchQuery2 ="jobID";
//				//boolean found = false;
//			
//				for (int i = 0; i > arr.length; i++) {
//				    if (arr.getString(i).equals(searchText)) {
//				    	JSONArray obj = new JSONArray();
//						for (Document doc : ) {
//							obj.put(doc);
//				    	System.out.println("found" );
//				    }
//				}

//					System.out.println("jsonArray..." + jsonArray);
//					
//					if (docs != null) {
//						for (Document doc : docs) {
//							obj.put(doc);
// access documents e.g. doc.get()

// found = true;

// JSONArray[0] not a string.
//				
//				String[] array = moreQueriesArray.toList();
//				
//				// initialize value to search
//				String searchText = "jobId";
//				BasicDBObject searchQuery = new BasicDBObject();
//				searchQuery.append("$text", new BasicDBObject("$search", "\"" + searchText + "\""));
//				String valueToSearch = searchQuery.toString();
//				// initialize boolean variable
//				boolean isExists = false;
//				// iterate over array
//				for (int i = 0; i < array.length(); i++) {
//					// get the value at current array index
//					
//					String arrayValue = array[i];
//					// compare values
//					if (valueToSearch.equals(arrayValue)) {
//						isExists = true;
//						// if value is found, terminate the loop
//						break;
//					}
//				}
//				if (isExists) {
//					System.out.println("String is found in the array");
//				} else {
//					System.out.println("String is not found in the array");
//				}
//			
//					// initialize array
//				   
//					String searchText = "jobId";
//					BasicDBObject searchQuery = new BasicDBObject();
//					searchQuery.append("$text", new BasicDBObject("$search", "\"" + searchText + "\""));
//					
//					String[] array = { "one", "two", "three", "four" };
//					// initialize value to search
//					//String valueToSearch = "three";
//					// initialize boolean variable
//					boolean isExists = false;
//					// iterate over array
//					for (Document document : moreQueriesArray) {
//						// get the value at current array index
//						
//						String arrayValue = moreQueriesArray[i];
//						// compare values
//						
//							jsonArray.put(jsonArray);
//							
//							break;
//						
//					}
//					if (isExists) {
//						System.out.println("String is found in the array");
//					} else {
//						System.out.println("String is not found in the array");
//					}
//			
// System.out.println("moreQueriesArray: " + moreQueriesArray.toString());
