package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import androidx.cardview.widget.CardView;
import android.widget.ImageButton;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoryViewHolder> {

    private List<TopStory> topStories;
    private Context context;

    public TopStoriesAdapter(Context context, List<TopStory> topStories) {
        this.context = context;
        this.topStories = topStories;
    }

    @NonNull
    @Override
    public TopStoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top_story, parent, false);
        return new TopStoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopStoryViewHolder holder, int position) {
        TopStory topStory = topStories.get(position);
        holder.titleTextView.setText(topStory.getTitle());
        holder.descriptionTextView.setText(topStory.getDescription());
        holder.topStoryImageView.setImageResource(topStory.getImageResource());
    }

    @Override
    public int getItemCount() {
        return topStories.size();
    }

    static class TopStoryViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView titleTextView;
        TextView descriptionTextView;
        ImageView topStoryImageView;

        TopStoryViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            topStoryImageView = itemView.findViewById(R.id.topStoryImageView);
        }
    }
}
