package es.ulpgc.scraper;

import es.ulpgc.scraper.api.ServerApi;
import es.ulpgc.scraper.scrapper.ScrapperBooking;
import es.ulpgc.scraper.api.Web;
import es.ulpgc.scraper.scrapper.Scrapper;


public class Controller {
    private final Scrapper scrapperBooking;
    private final ServerApi web;

    public Controller() {
        scrapperBooking = new ScrapperBooking();
        web = new Web();
    }

    public void run(int nPages, String urlWithoutOffset) {
        scrapperBooking.scrapper(nPages, urlWithoutOffset);
        web.start();
    }

}
