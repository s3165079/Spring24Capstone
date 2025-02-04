package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;

@Entity
public class MaturityRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mat_rating_id")
    private Integer maturityRatingId;

    @Column(name = "mat_rating_min_age", nullable = false)
    private Integer minAge;

    @Column(name = "mat_rating_letter", nullable = false, length = 4)
    private String letter;

    @Column(name = "mat_rating_desc", nullable = false, length = 100)
    private String desc;

    // Constructors, getters, and setters
    public MaturityRating() {
    }

    public Integer getID() {
        return this.maturityRatingId;
    }

    public Integer getMinAge() {
        return this.minAge;
    }
    public void setMinAge(Integer minAge) { this.minAge = minAge; }

    public String getLetter() {
        return this.letter;
    }
    public void setLetter(String letter) { this.letter = letter; }

    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) { this.desc = desc; }
}
