package com.shubhampriya1.assignment;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.shubhampriya1.assignment.controller.Student;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;

public class MyDropwizardProjectApplication extends Application<MyDropwizardProjectConfiguration> {

    public static void main(final String[] args) throws Exception {

        if (args.length == 0) {
            new MyDropwizardProjectApplication().run("server",
                    "C:\\Users\\shubh\\Downloads\\AssignmentDropwizard\\AssignmentDropwizard\\my-dropwizard-project\\config.yml");
        } else {
            new MyDropwizardProjectApplication().run(args);
        }

    }

    @Override
    public String getName() {
        return "MyDropwizardProject";
    }

    @Override
    public void run(final MyDropwizardProjectConfiguration configuration,
            final Environment environment) {
        // Fetch MongoDB configuration
        MongoConfiguration mongoConfig = configuration.getMongo();

        // Create MongoClient and MongoDatabase
        MongoClient mongoClient = MongoClients.create(mongoConfig.getUri());
        MongoDatabase database = mongoClient.getDatabase(mongoConfig.getDatabase());

        // Register Student resource
        environment.jersey().register(new Student(database));
    }

}
