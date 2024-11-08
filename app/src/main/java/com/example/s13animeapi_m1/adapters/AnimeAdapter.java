package com.example.s13animeapi_m1.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.s13animeapi_m1.R;
import com.example.s13animeapi_m1.activities.AnimeDetailActivity;
import com.example.s13animeapi_m1.entities.Anime;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    private List<Anime> animeList;
    private Context context;

    public AnimeAdapter(List<Anime> animeList, Context context) {
        this.animeList = animeList;
        this.context = context;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Anime anime = animeList.get(position);
        holder.textViewTitle.setText(anime.getTitle());
        holder.textViewEpisodes.setText("Episodio: " + anime.getEpisodes());

        // Cargar la imagen con Glide
        Glide.with(context)
                .load(anime.getImages().getJpg().getImageUrl())  // Usar la URL de imagen del modelo
                .into(holder.imageView);

        //pasar al Detallle
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, AnimeDetailActivity.class);
            intent.putExtra("animeId", anime.getMalId()); // Pasar el ID del anime
            intent.putExtra("title", anime.getTitle());
            intent.putExtra("airedDate", anime.getAired().getFrom());
            intent.putExtra("episodes", anime.getEpisodes());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle, textViewEpisodes;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.anime_image);
            textViewTitle = itemView.findViewById(R.id.anime_title);
            textViewEpisodes = itemView.findViewById(R.id.anime_episodes);
        }
    }
}
