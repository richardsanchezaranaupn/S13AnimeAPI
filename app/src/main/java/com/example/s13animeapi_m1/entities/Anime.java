package com.example.s13animeapi_m1.entities;

import com.google.gson.annotations.SerializedName;

public class Anime {
    @SerializedName("mal_id")
    private int malId;

    @SerializedName("title")
    private String title;

    @SerializedName("episodes")
    private int episodes;

    @SerializedName("images")
    private Image images;

    @SerializedName("aired")
    private Aired aired;

    // Getters
    public int getMalId() {
        return malId;
    }

    public String getTitle() {
        return title;
    }

    public int getEpisodes() {
        return episodes;
    }

    public Image getImages() {
        return images;
    }

    public Aired getAired() {
        return aired;
    }
}