package com.example.travelagency.models;

public class Trending {

    private int destinationImageId;
    private String destinationName;
    private int price;

    public Trending(int destinationImageId, String destinationName, int price) {
        this.destinationImageId = destinationImageId;
        this.destinationName = destinationName;
        this.price = price;
    }

    public int getDestinationImageId() {
        return destinationImageId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public int getPrice() {
        return price;
    }
}
