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
 
public class UpdateWithIncDemo {
 
 public static void main(String[] args) throws UnknownHostException {
 
     // Ket noi MongoDB.
     MongoClient mongoClient = MongoUtils.getMongoClient();
 
     // Ket noi Database
     DB db = mongoClient.getDB(MyConstants.DB_NAME);
 
     // Lay ra Collection voi City.
     DBCollection city = db.getCollection("City");
 
     // Tim cac City co city_no = "NYO".
     DBObject whereClause = new BasicDBObject("city_no", "NYO");
 
     DBObject values1 = new BasicDBObject();
     values1.put("population", 10000);
     
     DBObject values2 = new BasicDBObject();  
     values2.put("description", "Pop 2014");
    
    
     DBObject valuesSI = new BasicDBObject();
     valuesSI.put("$inc", values1);
     valuesSI.put("$set", values2);

     // update.
     WriteResult result = city.update(whereClause, valuesSI);
    
     int effectedCount = result.getN();
     System.out.println("Effected Count: " + effectedCount);
     System.out.println("Done!");
 }
 
}
