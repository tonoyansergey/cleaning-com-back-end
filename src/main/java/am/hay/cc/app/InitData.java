package am.hay.cc.app;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitData {

    public static void main(String[] args) {

        // Initializing MongoDB connection
        MongoClient client = new MongoClient("localhost", 27017);

        // Defining database
        MongoDatabase database = client.getDatabase("cc_be");

        // Defining collections
        List<String> collections = new ArrayList<>();

        collections.add("after_repair_cleaning");
        collections.add("basic_cleaning");
        collections.add("benefit");
        collections.add("feature");
        collections.add("general_cleaning");
        collections.add("home_cleaning");
        collections.add("maintain_cleaning");
        collections.add("office_cleaning");
        collections.add("question_answer");
        collections.add("service_type");
        collections.add("window_cleaning");


        for (String coll : collections) {
            MongoCollection<Document> collection = database.getCollection(coll);

            int count = 0;
            int batch = 100;

            List<InsertOneModel<Document>> docs = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/mongo/" + coll + ".json"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    docs.add(new InsertOneModel<>(Document.parse(line)));
                    count++;
                    if (count == batch) {
                        collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
                        docs.clear();
                        count = 0;
                    }
                }
            } catch (IOException ioe) {
                System.out.println("error");
            }

            if (count > 0) {
                collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
            }
        }
    }
}
