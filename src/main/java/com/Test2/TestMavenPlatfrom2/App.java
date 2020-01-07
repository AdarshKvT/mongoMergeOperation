package com.Test2.TestMavenPlatfrom2;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://sachin:sachin@cluster0-emxhp.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("aadarshdb");
		MongoCollection<Document> userDocument = database.getCollection("document_upload");
		List list = new LinkedList();
		String mobile = "+91 9920708743";
	//	String email = "aarti@acc.ltd";
		
		List<Document> document_upload = (List<Document>) userDocument.find(eq("mobile", mobile))
				.into(new ArrayList<Document>());
		if (document_upload != null && !(document_upload.isEmpty())) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("data", document_upload);

			JSONArray dataArray = jsonObj.optJSONArray("data");
			JSONObject objectIndex = dataArray.getJSONObject(0);
			JSONArray documents = objectIndex.optJSONArray("documents");
			System.out.println("array" + documents);
			if (documents != null && documents.length() > 0) {
				if (documents != null && !(documents.isNull(0))) {

					for (int i = 0; i < documents.length(); i++) {
						Map map = new LinkedHashMap();

						String name = "aadhar";
						String status = "rejected";
						System.out.println(documents.getJSONObject(i).getString("name"));
//					if (body.getString("name")
//							.equalsIgnoreCase(array.getJSONObject(i).getString("name"))) {
						System.out.println("PANARRAY: " + documents.getJSONObject(i).getString("name"));
						if (name.equalsIgnoreCase(documents.getJSONObject(i).getString("name"))) {
							System.out.println("enter in IF pan");
							// map.put("status", body.optString("rejected"));
							map.put("name", documents.getJSONObject(i).optString("name"));
							map.put("s3url", documents.getJSONObject(i).optString("s3url"));
							map.put("mimeType", documents.getJSONObject(i).optString("mimeType"));
							map.put("status", "rejected");
							//map.put("name", name);
							list.add(map);

						} else {
							System.out.println("enter into else");
							map.put("name", documents.getJSONObject(i).optString("name"));
							map.put("s3url", documents.getJSONObject(i).optString("s3url"));
							map.put("mimeType", documents.getJSONObject(i).optString("mimeType"));
							map.put("status", documents.getJSONObject(i).optString("status"));
							list.add(map);

						}
					}

					Document doc1 = new Document("documents", list);

					BasicDBObject query = new BasicDBObject();
					query.append("mobile", mobile);
					System.out.println("document query: " + query);

					Bson newDocument = new Document("$set", doc1);
					UpdateResult result = userDocument.updateOne(query, newDocument,
							(new UpdateOptions()).upsert(true));
					System.out.println(newDocument);
					System.out.println("Document upadte successful");

				}
			}
		}
	}

}
