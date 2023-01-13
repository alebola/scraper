package es.ulpgc.scraper.model;

public class Location {
    public String address;
    public String coordinates;

    public Location(String address, String coordinates) {
        this.address = address;
        this.coordinates = coordinates;
    }
}
