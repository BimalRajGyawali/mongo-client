package me.personal.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.util.ArrayList;
import java.util.List;

public class MongoService {

    private MongoClient getMongoClient(){
        return MongoClients.create("mongodb://localhost:27017");
    }

    public List<String> listAllDatabaseNames(){
        var databaseNames = new ArrayList<String>();
        try(var mongoClient = getMongoClient()) {
            for (String name : mongoClient.listDatabaseNames()) {
                databaseNames.add(name);
            }
        }
        return databaseNames;
    }

    public List<String> listAllCollectionNames(String database){
        var collectionNames = new ArrayList<String>();
        try(var mongoClient = getMongoClient()){
            for (String collectionName : mongoClient.getDatabase(database).listCollectionNames()) {
                collectionNames.add(collectionName);
            }
        }
        return collectionNames;
    }
}
