package com.paras.JobListing.PostRepository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.paras.JobListing.Post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts = new ArrayList<>();

        // Get the MongoDB database and collection
        MongoDatabase database = client.getDatabase("paras");
        MongoCollection<Document> collection = database.getCollection("Joblisting");

        // Build the aggregation pipeline
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search", new Document("text",
                        new Document("query", text)  // Use the 'text' argument passed to the method
                                .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort", new Document("exp", 1L)),  // Sort by 'exp' field
                new Document("$limit", 5L)  // Limit results to 5
        ));

        result.forEach(doc->posts.add(converter.read(Post.class,doc)));



        // Return the list of Post objects
        return posts;
    }
}
