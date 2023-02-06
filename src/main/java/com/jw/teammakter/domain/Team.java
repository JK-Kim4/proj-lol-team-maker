package com.jw.teammakter.domain;

public class Team {

    private Player top;
    private Player jungle;
    private Player apcarry;
    private Player adcarry;
    private Player supporter;

    private int totalRating;

    public void setTop(Player top){
        this.top = top;
    }

    public void setJungle(Player jungle) {
        this.jungle = jungle;
    }

    public void setApcarry(Player apcarry) {
        this.apcarry = apcarry;
    }

    public void setAdcarry(Player adcarry) {
        this.adcarry = adcarry;
    }

    public void setSupporter(Player supporter) {
        this.supporter = supporter;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public Player getTop() {
        return top;
    }

    public Player getJungle() {
        return jungle;
    }

    public Player getApcarry() {
        return apcarry;
    }

    public Player getAdcarry() {
        return adcarry;
    }

    public Player getSupporter() {
        return supporter;
    }

    public int getTotalRating() {
        return totalRating;
    }
}
