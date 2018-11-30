package org.DOAN3.MongoDB;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Projections;
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
	    MongoDatabase database = mongoClient.getDatabase("database");
	    MongoCollection<Document> collection = database.getCollection("ratings");
	    {
	    collection.aggregate(
	    	      Arrays.asList(
	    	              Aggregates.match(Filters.eq("ratings", "4.0")),
	    	              Aggregates.group("_id", Accumulators.sum("count", 1))
	    	      )
	    	).forEach(printBlock);
}
	    }
