package org.DOAN3.MongoDB;

import java.net.UnknownHostException;
import java.util.Set;
 
import org.DOAN3.MongoDB.MongoUtils;
import org.DOAN3.MongoDB.MyConstants;
 
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
 
public class GettingCollectionDemo {
 
   public static void main(String[] args) throws UnknownHostException {
 
       MongoClient mongoClient = MongoUtils.getMongoClient();
       DB db = mongoClient.getDB(MyConstants.DB_NAME);
 
       DBCollection dept = db.getCollection("Department");
        
       System.out.println("Collection: "+ dept);
        
       // So Document.
       // Chu y: Document trong MongoDB tuong ung voi 1 dong du dieu trong co so du lieu quan he
        
       long rowCount = dept.count();
       System.out.println(" Document count: "+ rowCount);
        
       System.out.println(" ------------ ");
        
       // Danh sach cac Collection
       Set<String> collections = db.getCollectionNames();
        
       for(String coll: collections)  {
           System.out.println("Collection: "+ coll);
       }
        
   }
 
}
