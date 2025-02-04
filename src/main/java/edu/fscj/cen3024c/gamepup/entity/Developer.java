package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private Integer developerId;

    @Column(name = "dev_name", length = 50, nullable = false)
    private String developerName;

    @Column(name = "dev_desc", length = 300)
    private String developerDesc;

    public Developer(){}

    public Integer getDeveloperId() { return developerId; }

    public void setDeveloperId(Integer developerId) { this.developerId = developerId; }

    public String getDeveloperName() { return developerName; }

    public void setDeveloperName(String developerName) { this.developerName = developerName; }

    public String getDeveloperDesc() { return developerDesc; }

    public void setDeveloperDesc(String developerDesc) { this.developerDesc = developerDesc; }
}
