package es.ulpgc.scraper.model;

import java.util.List;
import java.util.Map;

public class Hotel {
    private String name;
    private Location location;
    private Map<String,String> ratings;
    private List<String> services;
    private List<Comment> comments;

    public Hotel(String name, Location location, Map<String, String> ratings, List<String> services, List<Comment> comments) {
        this.name = name;
        this.location = location;
        this.ratings = ratings;
        this.services = services;
        this.comments = comments;
    }

    public Map<String, String> getRatings() {
        return ratings;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }



    public List<String> getServices() {
        return services;
    }
}
