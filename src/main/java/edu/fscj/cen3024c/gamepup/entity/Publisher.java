package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "publisher")
public class Publisher {
    // column attributes
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "pub_id")
    private Integer publisherId;

    @Column (name = "pub_name", length = 50)
    private String publisherName;

    @Column (name = "pub_desc", length = 300)
    private String publisherDesc;

    //constructors getters and setters
    public Publisher(){}
    public Integer getPublisherId(){ return publisherId; }

    public String getPublisherName(){ return publisherName; }

    public void setPublisherName(String publisherName){ this.publisherName = publisherName; }

    public String getPublisherDesc(){ return publisherDesc; }

    public void setPublisherDesc(String publisherDesc){
        this.publisherDesc = publisherDesc;
    }

}
