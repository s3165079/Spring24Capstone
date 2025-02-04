package edu.fscj.cen3024c.gamepup.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class GameDTO {
    //fields
    private Set<PublisherDTO> publishers;
    private Set<DeveloperDTO> developers;
    private Set<ConsoleDTO> consoles;
    private MaturityRatingDTO maturityRating;
    private String gameName;
    private String gameDesc;
    private String gameImage;
    private LocalDateTime releaseDate;

    //added 04/16/2024 for search by multiplayer/online play
    private int numPlayers;
    private boolean isCoOp;
    private boolean isOnline;

    //added 04/16/2024 for search by low play time and high rating
    private Integer playTime;
    private double avgReviewRating;

    //constructor
    public GameDTO() {
    }

    //getters and setters
    public Set<PublisherDTO> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<PublisherDTO> publishers) {
        this.publishers = publishers;
    }

    public Set<DeveloperDTO> getDevelopers() { return developers; }

    public void setDevelopers(Set<DeveloperDTO> developers) { this.developers = developers; }

    public Set<ConsoleDTO> getConsoles() { return this.consoles; }

    public void setConsoles(Set<ConsoleDTO> consoles) { this.consoles = consoles; }

    public MaturityRatingDTO getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(MaturityRatingDTO maturityRating) {
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
    public Integer getPlayTime() { return playTime; }

    public void setPlayTime(Integer playTime) { this.playTime = playTime; }

    public double getAvgReviewRating() { return avgReviewRating; }

    public void setAvgReviewRating(double avgReviewRating) {
        this.avgReviewRating = avgReviewRating; }

}
