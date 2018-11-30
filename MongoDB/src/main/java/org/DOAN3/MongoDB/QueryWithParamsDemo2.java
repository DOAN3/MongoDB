package org.DOAN3.MongoDB;

import java.net.UnknownHostException;
import java.util.regex.Pattern;
 
import org.DOAN3.MongoDB.MongoUtils;
import org.DOAN3.MongoDB.MyConstants;
 
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
 

// where dept_name like '%S%' and description is null

public class QueryWithParamsDemo2 {
 
  
// dept_name like '%S%' and description is null
// Xay dung JSON:
// { "dept_name" : { "$regex" : ".*S.*"} , "description" : null }
  public static DBObject getWhereClause_1() {
 
      BasicDBObjectBuilder whereBuilder = BasicDBObjectBuilder.start();
      
      // Su dung append va add
      whereBuilder.push("dept_name").add("$regex", ".*S.*") ;
      whereBuilder.pop();
      whereBuilder.append("description", null);
      //
      DBObject where = whereBuilder.get();
      System.out.println("Where " + where.toString());
      return where;
  }
  
// dept_name like '%S%' and description is null
// Xay dung JSON:
// { "dept_name" : { "$regex" : ".*S.*"} , "description" : null }
  public static DBObject getWhereClause_2() {
 
      BasicDBObjectBuilder whereBuilder = BasicDBObjectBuilder.start();

      String regex = ".*S.*";
      Pattern pattern = Pattern.compile(regex);
 
      whereBuilder.append("dept_name", pattern);
      whereBuilder.append("description", null);
      //
      DBObject where = whereBuilder.get();
      System.out.println("Where: " + where.toString());
      return where;
  }
 
  public static void main(String args[]) throws UnknownHostException {
  
      // Ket noi toi MongoDB.
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