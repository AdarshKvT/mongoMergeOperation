package com.Test2.TestMavenPlatfrom2;

import java.sql.DatabaseMetaData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONObject;

import com.Test2.Utils.*;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;

public class HrCandidateReview {

	public static void main(String[] args) {
		
		// testDatabse.collection
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://sachin:sachin@cluster0-emxhp.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("testDatabse");
		MongoCollection<Document> collection = database.getCollection("collection");

		//get aray from json
//		JSONArray user_detArray = new JSONArray(); 
//		// search query in user_details
//		for (Object doc : user_detArray) {
//			user_detArray.put(doc);
//		}
		
//		JSONArray array=jsonobj.optJSONArray("documents");
//		Map map = new HashMap();
//		for (int i = 0; i < array.length(); i++) {
//		map.put("name",array.getJSONObject(i).getString("name"));
//		map.put("s3url",array.getJSONObject(i).getString("s3url"));
//		}
//		
//		arrayList.add(map);
//		Document jsonDoc = new Document("documents", arrayList).append("businessUnit", businessUnit);
//		BasicDBObject query = new BasicDBObject();
//		query.append("email",userid);
//
//		Bson newDocument = new Document("$set", jsonDoc);
//		UpdateResult result = userDocument.updateOne(query, newDocument, (new UpdateOptions()).upsert(true));
//		response.put("message", "Document upload successful");
//		
		 
		
		//get values for uploading
		Map Integrity_Ethics = new HashMap();
		Integrity_Ethics.put("rate", 3);
		Integrity_Ethics.put("comment", "This is awesome");
		
		Map jobKnowledge = new HashMap();
		jobKnowledge.put("rate", 4);
		jobKnowledge.put("comment", "Abra ka dabra");
		
		Map personal_profile = new HashMap();
		personal_profile.put("rate", 5);
		personal_profile.put("comment","Bharat");
		
		Map teamwork = new HashMap();
		teamwork.put("rate", 3);
		teamwork.put("comment", "This is awesome");
		
		
		Map communicationSkills = new HashMap();
		communicationSkills.put("rate", 3);
		communicationSkills.put("comment", "This is awesome");
		
		
//		BasicDBList personal_profile = new BasicDBList();
//		personal_profile.add(new BasicDBObject("rate", 5));
//		personal_profile.add(new BasicDBObject("comment", "Bharat"));
		

		//mapping code
		Map map = new HashMap();
		map.put("Integrity_Ethics", Integrity_Ethics);
		map.put("jobKnowledge", jobKnowledge);
		map.put("personal_profile", personal_profile);
		map.put("communicationSkills", communicationSkills);
		//array
		JSONArray review = new JSONArray();
		review.put(map);
		
		//upload code
		Document document = new Document("review",map);
		Document update = new Document("$set", document);
		
		BasicDBObject filter = new BasicDBObject();
		filter.append("name", "adarsh");
		
		collection.updateOne(filter, update);
		//for single doc to be inserted 
		//collection.insertOne(document);
		//UpdateResult result = collection.updateOne(query, newDoc, (new UpdateOptions()).upsert(true));
		System.out.println("data uploaded successfully");
		
	}

}
