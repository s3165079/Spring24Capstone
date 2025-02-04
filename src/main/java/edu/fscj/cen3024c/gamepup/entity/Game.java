package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", unique = true, nullable = false)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game")
    private Set<UserGame> userGame;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Publisher> publishers;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Developer> developers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
      name = "game_console",
      joinColumns = @JoinColumn(name = "game_id"),
      inverseJoinColumns = @JoinColumn(name = "console_id"))
    private Set<Console> consoles;

    @ManyToOne
    @JoinColumn(name = "mat_rating_id", nullable = false)
    private MaturityRating maturityRating;

    @Column(name = "game_name", nullable = false, length = 200)
    private String gameName;

    @Column(name = "game_desc", nullable = false, length = 300)
    private String gameDesc;

    @Column(name = "game_image", length = 200)
    private String gameImage;

    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    //added 04/16/2024 for search by multiplayer/online play
    @Column(name = "number_of_players", nullable = false)
    private int numPlayers;

    @Column(name = "is_coop", nullable = false)
    private boolean isCoOp;

    @Column(name = "is_Online", nullable = false)
    private boolean isOnline;

    //added 04/16/2024 for search by low play time and high rating
    @Column(name = "play_time", nullable = false)
    private Integer playTime;

    @Column(name = "average_review_rating")
    private double avgReviewRating;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    //constructors getters and setters
    public Game() {
    }

    public Integer getId() {
        return id;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Set<Developer> getDevelopers() { return developers; }

    public void setDevelopers(Set<Developer> developers) { this.developers = developers; }

    public Set<Console> getConsoles() { return consoles; }

    public void setConsoles(Set<Console> consoles) { this.consoles = consoles; }

    public MaturityRating getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(MaturityRating maturityRating) {
        this.maturityRating = maturityRating;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDesc() {
        return gameDesc;
    }

    public void setGameDesc(String gameDesc) {
        this.gameDesc = gameDesc;
    }

    public String getGameImage() {
        return gameImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    //added 04/16/2024 for search by multiplayer/online play
    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) { this.numPlayers = numPlayers; }

    public boolean getIsCoOp() {
        return isCoOp;
    }

    public void setIsCoOp(boolean isCoOp) { this.isCoOp = isCoOp; }

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) { this.isOnline = isOnline; }

    //added 04/16/2024 for search by low play time and high rating
    public Integer getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Integer playTime) { this.playTime = playTime; }

    public double getAvgReviewRating() { return avgReviewRating; }

    public void setAvgReviewRating(double avgReviewRating) {
        this.avgReviewRating = avgReviewRating; }
}