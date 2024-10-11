package com.huffowicz.spotter.model;

public class SpotData {
    private String station;
    private String frequency;
    private String county;
    private String comment;
    private String poster;

    public SpotData() {}

    public SpotData(String station, String frequency, String county, String comment, String poster) {
        this.station = station;
        this.frequency = frequency;
        this.county = county;
        this.comment = comment;
        this.poster = poster;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
