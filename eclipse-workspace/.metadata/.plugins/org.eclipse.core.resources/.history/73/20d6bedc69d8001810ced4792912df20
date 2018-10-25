package org.DOAN3.MongoDB;

import java.net.UnknownHostException;

import org.DOAN3.MongoDB.MongoUtils;
import org.DOAN3.MongoDB.MyConstants;
 
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
 
public class QueryWithParamsDemo {
 
   // Xay dung JSON:
   // { "dept_name" : "ACCOUNTING"}
   private static DBObject getWhereClause_1() {
       BasicDBObjectBuilder whereBuilder = BasicDBObjectBuilder.start();
 
       // Su dung method append
       whereBuilder.append("dept_name", "ACCOUNTING");
       //
       DBObject where = whereBuilder.get();
       System.out.println("Where: " + where.toString());
       return where;
   }
 
   public static void main(String args[]) throws UnknownHostException {
 
       // Ket noi MongoDB.
       MongoClient mongoClient = MongoUtils.getMongoClient();
      
       DB db = mongoClient.getDB(MyConstants.DB_NAME);
 
       DBCollection dept = db.getCollection("Department");
 
       DBObject where = getWhereClause_1();
 
       // Truy van theo dieu kien
       DBCursor cursor = dept.find(where);
       int i = 1;
       while (cursor.hasNext()) {
           System.out.println("Document: " + i);
           System.out.println(cursor.next());
           i++;
       }
 
       System.out.println("Done!");
   }
}
