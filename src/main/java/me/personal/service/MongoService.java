package me.personal.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import javax.print.Doc;
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

    public List<Document> findAllDocuments(String collection){
        var documents = new ArrayList<Document>();
        try(var mongoClient = getMongoClient()){
            for (var document : mongoClient.getDatabase(MongoProperties.DB).getCollection(collection).find()) {
                    documents.add(document);
            }
        }
        return documents;
    }

    public List<Document> filter(String collection, Document condition){
        var documents = new ArrayList<Document>();
        try(var mongoClient = getMongoClient()){
            for (var document : mongoClient.getDatabase(MongoProperties.DB).getCollection(collection).find(condition)) {
                documents.add(document);
            }
        }

        return documents;
    }
}
