package me.personal;

import me.personal.service.MongoService;

public class Application {
    public static void main(String[] args) {
        var mongoService = new MongoService();

        mongoService.listAllDatabaseNames().forEach(System.out::println);
    }
}
