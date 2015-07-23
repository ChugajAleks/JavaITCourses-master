package org.javamongo;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException {
        System.out.println( "Hello World!" );
        MongoClient client = new MongoClient();

        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("hello");
        System.out.println(collection.findOne());
    }
}
