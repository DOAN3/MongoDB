package org.DOAN3.MongoDB;

import java.net.UnknownHostException;

import org.DOAN3.MongoDB.MongoUtils;
import org.DOAN3.MongoDB.MyConstants;
 
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
 
public class UpdateDemo {
 
  public static void main(String[] args) throws UnknownHostException {
 
      // Ket noi MongoDB.
      MongoClient mongoClient = MongoUtils.getMongoClient();
 
      // Ket noi Database
      DB db = mongoClient.getDB(MyConstants.DB_NAME);
 
      // Lay ra Collection ten City
      DBCollection city = db.getCollection("City");
 
      // Tim cac City co city_no = "WAS".
      DBObject whereClause = new BasicDBObject("city_no", "WAS");
 
      DBObject values = new BasicDBObject();
      values.put("population", 1200000);
      values.put("description", "Pop 2014");
      values.put("note", "Document replaced!");
 
      // update.
      WriteResult result = city.update(whereClause, values);
      int effectedCount = result.getN();
      System.out.println("Effected Count: " + effectedCount);
      System.out.println("Done!");
  }
 
}