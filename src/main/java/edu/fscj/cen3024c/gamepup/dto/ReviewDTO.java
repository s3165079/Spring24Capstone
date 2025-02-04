// ReviewDTO.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.dto;

public class ReviewDTO {
    private int reviewRating;
    private String reviewContent;
//    private LocalDate reviewDate;
//    private int reviewID;

    public ReviewDTO() {
    }


    public int getReviewRating() {
        return reviewRating;
    }

//    public LocalDate getReviewDate() {
//        return reviewDate;
//    }

    public String getReviewContent() {
        return reviewContent;
    }

//    public int getReviewID() { return reviewID; }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

//    public void setReviewDate(LocalDate reviewDate) {
//        this.reviewDate = reviewDate;
//    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

//    public void setReviewID(int reviewID) { this.reviewID = reviewID; }
}
