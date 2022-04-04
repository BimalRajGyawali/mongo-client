package me.personal.service;

import com.mongodb.client.MongoClients;

import java.util.ArrayList;
import java.util.List;

public class MongoService {

    public List<String> listAllDatabaseNames(){
        var databaseNames = new ArrayList<String>();
        try(var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            for (String name : mongoClient.listDatabaseNames()) {
                databaseNames.add(name);
            }
        }
        return databaseNames;
    }
}
