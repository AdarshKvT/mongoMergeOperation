import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;

//KvT Corporation

public class UpsertOperation {

	public static void main(String[] args) {

		MongoClientURI uri = new MongoClientURI("connectionUri");
		MongoClient mongoClient = new MongoClient(uri);

		MongoDatabase database = mongoClient.getDatabase("dbName");
		MongoCollection<Document> collection = database.getCollection("collectionName");

		// filter query
		BasicDBObject query = new BasicDBObject();
		query.put("name", "kakashi");

		// DBobject to be uploaded
		DBObject update = new BasicDBObject();

		// the keys to be merged
		Document doc = new Document();
		doc.put("Ability", "Lightning Blade");
		doc.put("Squad", "Team7");
		doc.put("Clan", "Uchiha");
		Bson newDoc = new Document("$set", doc);

		UpdateResult result = collection.updateOne(query, newDoc, (new UpdateOptions()).upsert(true));

		System.out.println("Doc merged successfully!!!");

	}

}
