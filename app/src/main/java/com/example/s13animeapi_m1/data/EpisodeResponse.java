package com.example.s13animeapi_m1.data;

import com.example.s13animeapi_m1.entities.Episode;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EpisodeResponse {
    @SerializedName("data")
    private List<Episode> episodes;

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
