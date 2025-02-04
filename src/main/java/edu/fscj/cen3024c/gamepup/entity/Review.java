// Review.java
// Authors: Matthew Stubbs & Dustin Locke
// Review Date: 4/16/2024

package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "review_id", nullable = false)
    private int reviewId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "review")
    private Set<UserGame> userGame;

    @Column(name = "review_rating", nullable = false)
    private int reviewRating;

    @Column(name = "review_content", length = 255)
    private String reviewContent;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    public int getReviewID() {
        return reviewId;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewID(int reviewID) {
        this.reviewId = reviewID;
    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o)
            result = true;
        else if (o != null && getClass() == o.getClass()) {
            Review review = (Review) o;
            result = reviewId == review.reviewId &&
                    reviewRating == review.reviewRating &&
                    Objects.equals(reviewContent, review.reviewContent) &&
                    reviewDate.equals(review.reviewDate);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, reviewRating, reviewContent, reviewDate);
    }

    @Override
    public String toString() {
        return "Review {" +
                "reviewID=" + reviewId +
                ", reviewRating='" + reviewRating + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewDate='" + reviewDate + '\'' +
                " }";
    }
}