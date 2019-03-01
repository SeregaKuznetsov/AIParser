import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.*;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    static MongoClient mongo = new MongoClient( "localhost" , 27017 );
    static DB db = mongo.getDB("dataset");
    static DBCollection table = db.getCollection("habr");

    public static void main(String[] args) {
        // JSoup Example 2 - Reading HTML page from URL

        Document doc = null;
        int exceptioncounter = 0;

        for (int i = 100000; i < 360000; i++) {

            try {
                doc = Jsoup.connect("https://habrahabr.ru/post/" + i +"/").get();
                System.out.println("Number of article: " + i);

            } catch (HttpStatusException ex) {
                System.out.println("Exception count: " + ++exceptioncounter);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (doc!=null) {
                writeToBD(doc);
            }

            doc = null;
        }
    }

    private static void writeToBD(Document jDoc) {

        BasicDBObject document = new BasicDBObject();
        document.put("tags", getTags(jDoc));
        document.put("text", getText(jDoc));
        table.insert(document);
    }

    private static String getText(Document jDoc) {
        return jDoc.select("div.post__text.post__text-html.js-mediator-article").text();
    }

    private static List<String> getTags(Document jDoc) {
        //a with href
        Elements links = jDoc.select("a.inline-list__item-link.post__tag");
        ArrayList<String> tags = new ArrayList<String>(links.size());

        for (Element link : links) {
            tags.add(link.text());
        }

        return tags;
    }
}
