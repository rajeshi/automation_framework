package in.zipgo.automation_framework.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;

public class MongoDBUtils {

    private final MongoClient client;

    public MongoDBUtils(String url) {
        client = new MongoClient(new MongoClientURI(url));
    }

    private MongoCollection<BasicDBObject> getCollection(String database, String collectionName) {
        return client.getDatabase(database).getCollection(collectionName, BasicDBObject.class);
    }

    public void insertData(String database, String collectionName, BasicDBObject obj) {
        getCollection(database, collectionName).insertOne(obj);
    }

    public List<BasicDBObject> findAll(String database, String collectionName) {
        FindIterable<BasicDBObject> obj = getCollection(database, collectionName).find();
        List<BasicDBObject> listAll = new ArrayList<>();
        while (obj.iterator().hasNext()) {
            listAll.add(obj.iterator().next());
        }
        return listAll;
    }
}
