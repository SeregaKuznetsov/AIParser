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

public class VRW {
    static MongoClient mongo = new MongoClient( "localhost" , 27017 );
    static DB db = mongo.getDB("dataset");
    static DBCollection table = db.getCollection("vrw");

    public static void main(String[] args) {
        // JSoup Example 2 - Reading HTML page from URL

        StringBuilder pageNumberWithException = new StringBuilder();
        List<String> linksWithException = new ArrayList<String>();
        int numberOfLink = 0;

        Document page = null;
        Document doc = null;

        for (int i = 1; i < 67; i++) {

            try {
                page = Jsoup.connect("http://rus.vrw.ru/sitemap/"+i+"/").get();
                System.out.println("Number of page: " + i);
            } catch (HttpStatusException ex) {
                System.out.println("Number of page with ex: " + i);
                pageNumberWithException.append(i).append(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (page!=null) {

                Elements links = page.select("div.sitemap.sitemap_list > ul > li > a");

                for (Element link : links) {

                    try {
                        doc = Jsoup.connect(link.attr("href")).get();
                        System.out.println("Number of link: " + ++numberOfLink);
                    } catch (HttpStatusException ex) {
                        System.out.println("link with exception: " + link.attr("href"));
                        linksWithException.add(link.attr("href"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (doc != null) {
                        writeToBD(doc);
                    }

                    doc = null;
                }
            }
            page = null;
        }

        System.out.println("--------------------THIS IS THE END-------------------");
        System.out.println(pageNumberWithException);
        System.out.println(linksWithException);
    }

    private static void writeToBD(Document jDoc) {

        BasicDBObject document = new BasicDBObject();
        document.put("mood", "good");
        document.put("text", getText(jDoc));
        table.insert(document);
    }

    private static String getText(Document jDoc) {
        return jDoc.select("div.page_content.type_page_content > p").text();
    }
}
