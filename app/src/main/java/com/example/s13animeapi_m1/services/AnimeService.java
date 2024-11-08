package com.example.s13animeapi_m1.services;

import com.example.s13animeapi_m1.data.AnimeResponse;
import com.example.s13animeapi_m1.data.EpisodeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AnimeService {
    @GET("anime")
    Call<AnimeResponse> getAnimes();

    @GET("anime")
    Call<AnimeResponse> getAnimeSearch(@Query("q") String query);

    @GET("anime/{id}/episodes")
    Call<EpisodeResponse> getAnimeEpisodes(@Path("id") int animeId);
}
