package com.shubhampriya1.assignment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shubhampriya1.assignment.dto.ResponseDto;
import org.bson.Document;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/home")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Student {

    private final MongoCollection<Document> collection;

    // Constructor to initialize MongoDB Collection
    public Student(MongoDatabase database) {
        this.collection = database.getCollection("users");
    }

    @GET
    public Response home() {
        return Response.ok().entity(new ResponseDto("Welcome Home", 200)).build();
    }

    @GET
    @Path("/{userName}")
    public Response username(@PathParam("userName") String userName) {
        Document user = new Document("name", userName);
        collection.insertOne(user);

        return Response.ok().entity(new ResponseDto("Welcome " + userName, 200)).build();
    }

    @GET
    @Path("/allUsers")
    public Response getAllUsers() {
        Map<String, Object> response = new HashMap<>();
        ArrayList<Document> users = collection.find().into(new ArrayList<>());

        response.put("users", users);
        response.put("status", 200);
        return Response.ok(response).build();
    }
}
