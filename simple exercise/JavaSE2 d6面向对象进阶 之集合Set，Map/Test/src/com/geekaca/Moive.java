package com.geekaca;

public class Moive {
    private String name;
    private double score;
    private String actor;

    public Moive(String name, double score, String actor) {
        this.name = name;
        this.score = score;
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Moive{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", actor='" + actor + '\'' +
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
}
