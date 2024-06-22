package com.geekaca;

import java.time.LocalDateTime;

public class Moive {
    private String name;
    private double score;
    private String actor;
    private LocalDateTime onTime;

    public Moive(String name, double score, String actor, LocalDateTime onTime) {
        this.name = name;
        this.score = score;
        this.actor = actor;
        this.onTime = onTime;
    }

    @Override
    public String toString() {
        return "Moive{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", actor='" + actor + '\'' +
                ", onTime=" + onTime +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public LocalDateTime getOnTime() {
        return onTime;
    }

    public void setOnTime(LocalDateTime onTime) {
        this.onTime = onTime;
    }
}

