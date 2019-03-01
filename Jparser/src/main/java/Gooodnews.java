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

public class Gooodnews {
    static MongoClient mongo = new MongoClient( "localhost" , 27017 );
    static DB db = mongo.getDB("dataset");
    static DBCollection table = db.getCollection("goodnews");

    public static void main(String[] args) {
        // JSoup Example 2 - Reading HTML page from URL

        StringBuilder pageNumberWithException = new StringBuilder();
        int emptyPage = 0;
        List<String> linksWithException = new ArrayList<String>();
        int numberOfLink = 0;

        Document page = null;
        Document doc = null;

        for (int i = 0; i < 5000; i = i + 5) {

            try {
                page = Jsoup.connect("http://gooodnews.ru/index.php/pozitivnoe/good-news?start="+ i ).get();
                System.out.println("Number of page: " + i);
            } catch (HttpStatusException ex) {
                System.out.println("Number of page with ex: " + i);
                pageNumberWithException.append(i).append(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (page!=null) {

                Elements links = page.select("a.readmore-link");

                for (Element link : links) {

                    try {
                        doc = Jsoup.connect("http://gooodnews.ru" + link.attr("href")).get();
                        System.out.println("Number of link: " + ++numberOfLink);
                    } catch (HttpStatusException ex) {
                        System.out.println("link with exception: " + link.attr("href"));
                        linksWithException.add(link.attr("href"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (doc != null) {
                        String text = getText(doc);
                        if (text.length() > 300 ) {
                            writeToBD(text);
                        } else {
                            System.out.println("empty count: " + ++emptyPage);
                        }
                    }

                    doc = null;
                }
            }
            page = null;
        }

        System.out.println("--------------------THIS IS THE END-------------------");
        System.out.println(pageNumberWithException);
        System.out.println(linksWithException);
        System.out.println("empty count: " + emptyPage);


    }

    private static void writeToBD(String text) {

        BasicDBObject document = new BasicDBObject();
        document.put("mood", "good");
        document.put("text", text);
        table.insert(document);
    }

    private static String getText(Document jDoc) {
        return jDoc.select("body > div > div:nth-child(3) > div.container > div.row > div.content_sparky.span7 > div > div.item-page > p").text();
    }
}
