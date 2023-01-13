import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class TestApi {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://localhost:4567/hotels/Hotel Cordial Mogán Playa/services").get();
            String text = doc.text();
            System.out.println(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
