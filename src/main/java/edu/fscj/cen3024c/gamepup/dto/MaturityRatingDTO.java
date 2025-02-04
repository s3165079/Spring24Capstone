package edu.fscj.cen3024c.gamepup.dto;

public class MaturityRatingDTO {
    //fields
    private Integer minAge;
    private String letter;
    private String desc;

    //constructor
    public MaturityRatingDTO(){}

    //getters and setters
    public Integer getMinAge() { return minAge; }
    public void setMinAge(Integer minAge) { this.minAge = minAge; }
    public String getLetter() { return letter; }
    public void setLetter(String letter) { this.letter = letter; }
    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }
}
