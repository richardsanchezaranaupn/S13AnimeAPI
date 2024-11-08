package com.example.s13animeapi_m1.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.s13animeapi_m1.ApiService;
import com.example.s13animeapi_m1.R;
import com.example.s13animeapi_m1.data.EpisodeResponse;
import com.example.s13animeapi_m1.entities.Episode;
import com.example.s13animeapi_m1.services.AnimeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeDetailActivity extends AppCompatActivity {
    private TextView title, airedDate, episodes;
    private int animeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);

        title = findViewById(R.id.detail_title);
        airedDate = findViewById(R.id.detail_aired_date);
        episodes = findViewById(R.id.detail_episodes);

        // Obtener datos pasados desde MainActivity
        animeId = getIntent().getIntExtra("animeId", 0); // Recibir ID del anime
        title.setText(getIntent().getStringExtra("title"));
        airedDate.setText("Fecha de Publicación: " + getIntent().getStringExtra("airedDate"));

        // Llamada para obtener episodios
        AnimeService apiService = ApiService.getRetrofitInstance().create(AnimeService.class);
        Call<EpisodeResponse> call = apiService.getAnimeEpisodes(animeId);

        call.enqueue(new Callback<EpisodeResponse>() {
            @Override
            public void onResponse(Call<EpisodeResponse> call, Response<EpisodeResponse> response) {
                if (response.body() != null) {
                    List<Episode> episodeList = response.body().getEpisodes();
                    StringBuilder episodeInfo = new StringBuilder();

                    for (Episode episode : episodeList) {
                        episodeInfo.append("Título: ").append(episode.getTitle())
                                .append("\nAired: ").append(episode.getAired()).append("\n\n");
                    }

                    episodes.setText(episodeInfo.toString());
                }
            }

            @Override
            public void onFailure(Call<EpisodeResponse> call, Throwable t) {
                Log.e("AnimeDetailActivity", "Error: " + t.getMessage());
            }
        });
    }
}