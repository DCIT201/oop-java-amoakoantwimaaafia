package com.vehiclerentalsystem;

public class Rating {
    private int score;
    private String comment;

    public Rating(int score, String comment) {
        if (score < 1 || score > 5) {
            throw new IllegalArgumentException("Score must be between 1 and 5.");
        }
        this.score = score;
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }
}
