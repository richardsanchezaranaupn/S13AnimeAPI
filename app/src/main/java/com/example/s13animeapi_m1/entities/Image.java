package com.example.s13animeapi_m1.entities;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("jpg")
    private Jpg jpg;

    public Jpg getJpg() {
        return jpg;
    }

    public static class Jpg {
        @SerializedName("image_url")
        private String imageUrl;

        public String getImageUrl() {
            return imageUrl;
        }

    }
}
