package es.ulpgc.scraper.scrapper;

import es.ulpgc.scraper.model.Comment;
import es.ulpgc.scraper.model.Hotel;
import es.ulpgc.scraper.model.Location;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScrapperBooking implements Scrapper{
    public static final List<Hotel> hotelsscraped = new ArrayList<>();

    private Document getHTML (String url) {
        Document html = null;

        try {
            html = Jsoup.connect(url).timeout(100000).get();
        } catch (Exception e) {
            System.out.println("Error al obtener código HTML");
        }
        return html;
    }

    public void scrapper(int paginas, String urlWithoutOffset) {

        int offset = 0;

        for (int i = 0; i < paginas; i++) {
            Document document = getHTML(urlWithoutOffset + offset);
            offset += 25;

            if (document == null) continue;
            Elements hotels = document.select("h3.a4225678b2");

            int pagina = i+1;
            System.out.println("Número de entradas en la página " + pagina + " de Booking: " + hotels.size() + "\n");
            for (Element hotel : hotels) {
                try {
                    String urlTotalHotel = hotel.select("a").attr("abs:href");
                    String urlHotel = urlTotalHotel.substring(0, urlTotalHotel.indexOf("?"));
                    Document hotelHTML = getHTML(urlHotel);

                    String sub = "https://www.booking.com/reviews/es/hotel/";
                    String urlReviewHotel = sub + urlHotel.substring(33);
                    Document reviewHotelHTML = getHTML(urlReviewHotel);


                    String hotelName = scrapperName(hotelHTML);
                    Location hotelLocation = scrapperLocation(hotelHTML);
                    List<String> hotelServices = scrapperService(hotelHTML);
                    Map<String, String> hotelRatings = scrapperRating(hotelHTML);
                    List<Comment> hotelComments = scrapperComment(reviewHotelHTML);



                    Hotel hotelScraped = new Hotel(hotelName, hotelLocation, hotelRatings, hotelServices, hotelComments);
                    hotelsscraped.add(hotelScraped);


                    System.out.println(hotelName);
                    System.out.println(hotelServices);
                    System.out.println(hotelRatings);
                    System.out.println(hotelLocation.address);
                    System.out.println(hotelComments.get(0).getCommentdate());
                    System.out.println("\n");
                } catch (Exception e) {
                    System.out.println("Error al encontrar los hoteles");
                }
            }
        }
    }

    private String scrapperName(Document hotelHTML) {
        Elements names = hotelHTML.getElementsByClass("d2fee87262 pp-header__title");
        return names.get(0).text();
    }

    private Location scrapperLocation(Document hotelHTML) {
        String hotelDirection = null;
        String coordinates = hotelHTML.select("a").attr("data-atlas-latlng");
        Elements locations = hotelHTML.getElementsByClass("\n" +
                "hp_address_subtitle\n" +
                "js-hp_address_subtitle\n" +
                "jq_tooltip\n"
        );
        for (Element location: locations) hotelDirection = location.text();
        return new Location(hotelDirection, coordinates);
    }

    private List<String> scrapperService(Document hotelHTML) {
        List<String> hotelServices = new ArrayList<>();
        Elements services = hotelHTML.getElementsByClass("bui-list__description");
        Elements services2 = hotelHTML.getElementsByClass("db312485ba");
        for (Element service: services) hotelServices.add(service.text());
        for (Element service: services2) hotelServices.add(service.text());
        return hotelServices;
    }

    private Map<String, String> scrapperRating(Document hotelHTML) {
        Map<String, String> hotelRatings = new HashMap<>();
        Elements nameRatings = hotelHTML.getElementsByClass("d6d4671780");
        Elements numberRatings = hotelHTML.getElementsByClass("ee746850b6 b8eef6afe1");

        for (int j = 0; j < 7; j++) hotelRatings.put(nameRatings.get(j).text(), numberRatings.get(j).text());

        return hotelRatings;
    }

    private List<Comment> scrapperComment(Document reviewhotelHTML) {
        List<Comment> hotelComments = new ArrayList<>();

        Elements comments = reviewhotelHTML.getElementsByClass( "review_item_header_content\n");
        Elements ratingsComment = reviewhotelHTML.getElementsByClass("review-score-badge");
        Elements dates = reviewhotelHTML.getElementsByClass("review_item_date");

        for (int j = 0; j < comments.size(); j++) hotelComments.add(new Comment(comments.get(j).text(),
                ratingsComment.get(j).text(), dates.get(j).text()));
        return hotelComments;
    }

}
