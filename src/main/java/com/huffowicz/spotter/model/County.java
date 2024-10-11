package com.huffowicz.spotter.model;
public class County {
    private String name;
    private String color;
    private String lat;
    private String lng;

    public County(String name, String color, String lat, String lng) {
        this.name = name;
        this.color = color;
        this.lat = lat;
        this.lng = lng;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}