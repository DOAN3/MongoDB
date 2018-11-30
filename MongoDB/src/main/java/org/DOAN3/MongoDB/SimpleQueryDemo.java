package org.DOAN3.MongoDB;

import java.net.UnknownHostException;

import org.DOAN3.MongoDB.MongoUtils;
import org.DOAN3.MongoDB.MyConstants;
 
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
 
public class SimpleQueryDemo {
 
  public static void main(String args[]) throws UnknownHostException {
    
      // Ket noi MongoDB.
      MongoClient mongoClient = MongoUtils.getMongoClient();
 
      DB db = mongoClient.getDB(MyConstants.DB_NAME);
 
      DBCollection dept = db.getCollection("Department");
 
      // Truy van tat ca object trong Collection
      DBCursor cursor = dept.find();
      int i = 1;
      while (cursor.hasNext()) {
          System.out.println("Document: " + i);
          System.out.println(cursor.next());
          i++;
      }
 
  }
}
