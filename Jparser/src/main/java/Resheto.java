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

public class Resheto {
    static MongoClient mongo = new MongoClient( "localhost" , 27017 );
    static DB db = mongo.getDB("dataset");
    static DBCollection table = db.getCollection("resheto");

    public static void main(String[] args) {
        // JSoup Example 2 - Reading HTML page from URL

        StringBuilder pageNumberWithException = new StringBuilder();
        int emptyPage = 0;
        List<String> linksWithException = new ArrayList<String>();
        int numberOfLink = 0;

        Document page = null;
        Document doc = null;

        for (int i = 9; i < 163; i = i + 9) {

            try {
                page = Jsoup.connect("https://resheto.net/novosti?start="+ i).validateTLSCertificates(false).get();
                System.out.println("Number of page: " + i);
            } catch (HttpStatusException ex) {
                System.out.println("Number of page with ex: " + i);
                pageNumberWithException.append(i).append(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (page!=null) {

                Elements links = page.select("a.btn");

                for (Element link : links) {

                    try {
                        doc = Jsoup.connect("https://resheto.net" + link.attr("href")).validateTLSCertificates(false).get();
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
//                            System.out.println(text);
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
        return jDoc.select("#conten > div.item-page.blo > div:nth-child(5) > p").text();
    }
}
