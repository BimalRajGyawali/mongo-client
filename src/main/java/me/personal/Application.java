package me.personal;

import me.personal.service.MongoService;
import org.bson.Document;

public class Application {
    public static void main(String[] args) {
        var mongoService = new MongoService();

        mongoService.listAllDatabaseNames().forEach(System.out::println);

        mongoService.listAllDatabaseNames().forEach(database ->
                mongoService.listAllCollectionNames(database).forEach(System.out::println)
        );

        mongoService.findAllDocuments("unicorns").forEach(System.out::println);

        mongoService.filter("animals", new Document("weight", 4)).forEach(System.out::println);

        mongoService.filter("animals", new Document("weight", new Document("$lt", 4))).forEach(System.out::println);

        mongoService.filter("animals", new Document("weight", new Document("$gt", 4))).forEach(System.out::println);
    }
}
