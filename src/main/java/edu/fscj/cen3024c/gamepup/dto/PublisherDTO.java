package edu.fscj.cen3024c.gamepup.dto;

public class PublisherDTO {
    //fields
    private String publisherName;
    private String publisherDesc;

    //constructor
    public PublisherDTO() {}

    //getters and setters
    public String getPublisherName() { return publisherName; }
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
    public String getPublisherDesc() { return publisherDesc; }
    public void setPublisherDesc(String publisherDesc) {
        this.publisherDesc = publisherDesc;
    }
}
