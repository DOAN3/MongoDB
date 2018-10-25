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
 
public class UpdateWithSetDemo {
 
  public static void main(String[] args) throws UnknownHostException {
 
 
      // Ket noi MongoDB.
      MongoClient mongoClient = MongoUtils.getMongoClient();
 
 
      // Ket noi Database
      DB db = mongoClient.getDB(MyConstants.DB_NAME);
 
      // Lay ra Collection voi ten City
      DBCollection city = db.getCollection("City");
 
      // Tim cac City co city_no = "CHI".
      DBObject whereClause = new BasicDBObject("city_no", "CHI");
 
      DBObject values = new BasicDBObject();
      values.put("population", 3400000);
      values.put("description", "Pop 2014");
      values.put("note", "Document update with $set");
      
      DBObject valuesWithSet = new BasicDBObject();
      valuesWithSet.put("$set", values);
 
      // update.
      WriteResult result = city.update(whereClause, valuesWithSet);
      
      int effectedCount = result.getN();
      System.out.println("Effected Count: " + effectedCount);
      System.out.println("Done!");
  }
 
}
