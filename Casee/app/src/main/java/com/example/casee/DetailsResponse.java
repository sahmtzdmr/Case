package com.example.casee;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

public class DetailsResponse {
    @SerializedName("title")
    String title;
    @SerializedName("vote_average")
    Double vote_average;



    @SerializedName("overview")
    String overview;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
