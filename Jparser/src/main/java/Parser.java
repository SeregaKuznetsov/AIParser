import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.*;
import entity.Article;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Projections.excludeId;

public class Parser {

    static MongoClient mongo = new MongoClient( "localhost" , 27017 );
    static DB db = mongo.getDB("dataset");
    static DBCollection table = db.getCollection("resheto");
    static Gson gson =  new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        BasicDBObject query = new BasicDBObject();
        DBCursor cursor = table.find(query);

        List<Article> arcticles = new ArrayList<>(cursor.size());

        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
            arcticles.add(new Article( cursor.next().get("text").toString(), "good"));
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Projects\\GitRepository\\Jparser\\src\\main\\resources\\" + table.getName() + ".json"))) {
            bw.write(gson.toJson(arcticles));
        } catch(IOException e){
            e.printStackTrace();
        }
    }


}
