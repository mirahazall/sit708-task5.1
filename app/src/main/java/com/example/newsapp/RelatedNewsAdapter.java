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

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.ViewHolder> {

    private Context context;
    private List<RelatedNewsItem> relatedNewsItems;

    public RelatedNewsAdapter(Context context, List<RelatedNewsItem> relatedNewsItems) {
        this.context = context;
        this.relatedNewsItems = relatedNewsItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_related_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RelatedNewsItem relatedNewsItem = relatedNewsItems.get(position);
        holder.relatedNewsImageView.setImageResource(relatedNewsItem.getImageResource());
        holder.relatedNewsTitleTextView.setText(relatedNewsItem.getTitle());
        holder.relatedNewsDescriptionTextView.setText(relatedNewsItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return relatedNewsItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView relatedNewsImageView;
        TextView relatedNewsTitleTextView;
        TextView relatedNewsDescriptionTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            relatedNewsImageView = itemView.findViewById(R.id.relatedNewsImageView);
            relatedNewsTitleTextView = itemView.findViewById(R.id.relatedNewsTitleTextView);
            relatedNewsDescriptionTextView = itemView.findViewById(R.id.relatedNewsDescriptionTextView);
        }
    }
}

