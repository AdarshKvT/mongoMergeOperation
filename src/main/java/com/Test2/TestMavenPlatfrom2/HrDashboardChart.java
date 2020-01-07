package com.Test2.TestMavenPlatfrom2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class HrDashboardChart {
	public static void main(String[] args) throws ParseException {

		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://sachin:sachin@cluster0-emxhp.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);

		DB database = mongoClient.getDB("aadarshdb");
		DBCollection user_details = database.getCollection("user_details");
		
		MongoDatabase database2 = mongoClient.getDatabase("aadarshdb");
		MongoCollection<Document> collection = database2.getCollection("user_details");
		
//		LocalDate formDate1 = LocalDate.now().minusMonths(5);
//		String fromDate = formDate1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("formattedDate1: " + fromDate);
//
//		LocalDate toDate1 = LocalDate.now();
//		String toDate = toDate1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("toDateFormat1--->>" + toDate);
//		
//		String fromDate = "1/10/2019";
//		String toDate = "7/1/2020";
//		
//		DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

//		try {
//			Bson filter = new Document("$gte", format.parse("2019-10-01T00:00:00Z")).append("$lt", format.parse("2020-1-02T00:00:00Z"));
//			long count = collection.count(new Document("field",filter) );
//			System.out.println("count"+count);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	
//		
//		BasicDBObject rejectedQuery = new BasicDBObject();
//		rejectedQuery.append("applicationDate", BasicDBObjectBuilder.start("$gte", fromDate).add("$lt", toDate).get()).append("applicationStatus","New");
//		//rejectedQuery.append("applicationStatus","New");
//		
//
//		Integer rejectCount = user_details.find(rejectedQuery).count();
//		System.out.println("reject candidate counts:  "+rejectCount);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy.MM.dd");
		String date ="2014.01.02"; 
		String date1 ="2014.01.10";
		Date startDate = simpleDateFormat.parse(date);  
		Date endDate = simpleDateFormat.parse(date1);
		
		BasicDBObject query = new BasicDBObject("fieldName",
				   new BasicDBObject("$gte",startDate).append("$lt",endDate ));
		
		
//		// ============================(Current month Applicant Count)==================
//
//		LocalDate formDate1 = LocalDate.now().minusMonths(1);
//		String formattedDate1 = formDate1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("formattedDate1: " + formattedDate1);
//
//		LocalDate toDate1 = LocalDate.now();
//		String toDateFormat1 = toDate1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("toDateFormat1--->>" + toDateFormat1);
//
//		// number of Applicant per Current Month Count
//		BasicDBObject applicantQuery1 = new BasicDBObject();
//		applicantQuery1.put("applicationDate",
//				BasicDBObjectBuilder.start("$gte", formattedDate1).add("$lte", toDateFormat1).get());
//		applicantQuery1.put("applicationStatus", "hired");
//
//		Integer applicantcount1 = user_details.find(applicantQuery1).count();
//		System.out.println("Current month Applicants Count: : " + applicantcount1);
//
//		// ====================(2 Previous month Applicant Count)=====
//
//		LocalDate fromDate2 = LocalDate.now().minusMonths(2);
//		String formattedDate2 = fromDate2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("formattedDate2--->>" + formattedDate2);
//
//		LocalDate toDate2 = LocalDate.now().minusMonths(1);
//		String toDateFormat2 = toDate2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("toDateFormat2--->>" + toDateFormat2);
//
//		BasicDBObject applicationQuery2 = new BasicDBObject();
//		applicationQuery2.put("applicationDate",
//				BasicDBObjectBuilder.start("&gte", formattedDate2).add("&lte", toDateFormat2).get());
//		applicationQuery2.put("applciationStatus", "hired");
//
//		Integer applicantCount2 = user_details.find(applicationQuery2).count();
//		System.out.println("2 Previous month Application Count: " + applicantCount2);
//
//		// ====================(3 Previous month Applicant Count)=====
//
//		LocalDate fromDate3 = LocalDate.now().minusMonths(3);
//		String fromDateFormat3 = fromDate3.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("minusOneMonth--->>" + fromDateFormat3);
//
//		LocalDate toDate3 = LocalDate.now().minusMonths(2);
//		String toDateFormat3 = toDate3.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("toDateFormat3--->>" + toDateFormat3);
//
//		BasicDBObject applicationQuery3 = new BasicDBObject();
//		applicationQuery3.put("applicationDate",
//				BasicDBObjectBuilder.start("&gte", fromDateFormat3).add("&lte", toDateFormat3).get());
//		applicationQuery3.put("applciationStatus", "hired");
//
//		Integer applicantCount3 = user_details.find(applicationQuery3).count();
//		System.out.println("3 Previous month Application Count: " + applicantCount3);
//
//		// ====================(3 Previous month Applicant Count)=====
//		LocalDate fromDate4 = LocalDate.now().minusMonths(4);
//		String fromdateFormat4 = fromDate4.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("fromdateFormat4--->>" + fromdateFormat4);
//
//		// current - 3 date
//		LocalDate toDate4 = LocalDate.now().minusMonths(3);
//		String toDateFormat4 = toDate4.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("minusThreeMonth--->>" + toDateFormat4);
//
//		BasicDBObject applicationQuery4 = new BasicDBObject();
//		applicationQuery4.put("applicationDate",
//				BasicDBObjectBuilder.start("&gte", fromdateFormat4).add("&lte", toDateFormat4).get());
//		applicationQuery4.put("applciationStatus", "hired");
//
//		Integer applicantCount4 = user_details.find(applicationQuery4).count();
//		System.out.println("3 Previous month Application Count: " + applicantCount4);
		
		mongoClient.close();
	}
}
