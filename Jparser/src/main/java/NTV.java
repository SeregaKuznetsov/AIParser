import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NTV {
    static MongoClient mongo = new MongoClient( "localhost" , 27017 );
    static DB db = mongo.getDB("dataset");
    static DBCollection table = db.getCollection("ntv");

    public static void main(String[] args) {
        // JSoup Example 2 - Reading HTML page from URL

        Document doc = null;
        int exceptioncounter = 0;

        for (int i = 1866378; i < 2000000; i++) {

            try {
                doc = Jsoup.connect("http://ntv.ru/novosti/"+i+"/").userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").referrer("http://www.google.com").get();
                System.out.println("Number of article: " + i);

            } catch (HttpStatusException ex) {
                System.out.println("Exception count: " + ++exceptioncounter);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (doc!=null) {
                writeToBD(doc);
//                System.out.println(getTags(doc));
//                System.out.println(getText(doc));
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
        return jDoc.select("div.nativeroll_px").text();
    }

    private static List<String> getTags(Document jDoc) {
        //a with href
        Elements links = jDoc.select("#newitemnsoc > table > tbody > tr > td:nth-child(2) > ul > li > a");
        ArrayList<String> tags = new ArrayList<String>(links.size());

        for (Element link : links) {
            tags.add(link.text());
        }

        return tags;
    }
}
