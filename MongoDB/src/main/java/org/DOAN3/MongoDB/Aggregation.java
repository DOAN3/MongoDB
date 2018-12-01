package org.DOAN3.MongoDB;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;

import java.util.Arrays;

import org.bson.Document;

public class Aggregation {
	 Block<Document> printBlock = new Block<Document>() {
	        @Override
	        public void apply(final Document document) {
	            System.out.println(document.toJson());
	        }
	    };
	    MongoClient mongoClient = new MongoClient();
	    MongoDatabase database = mongoClient.getDatabase("HoaLan");
	    MongoCollection<Document> collection = database.getCollection("data");
	    {
	    collection.aggregate(
	    	      Arrays.asList(
	    	              Aggregates.match(Filters.eq("Price", "250.000")),
	    	              Aggregates.group("_id", Accumulators.sum("count", 1))
	    	      )
	    	).forEach(printBlock);
}
	    }
