package edu.fscj.cen3024c.gamepup.exceptions;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException() {
        super("UserGame not found");
    }
}
