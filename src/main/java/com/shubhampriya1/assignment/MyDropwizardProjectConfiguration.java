package com.shubhampriya1.assignment;

import io.dropwizard.core.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyDropwizardProjectConfiguration extends Configuration {
    @JsonProperty("mongo")
    private MongoConfiguration mongo;

    public MongoConfiguration getMongo() {
        return mongo;
    }
}

class MongoConfiguration {
    private String uri;
    private String database;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}