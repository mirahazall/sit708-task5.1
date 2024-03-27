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

public class SecondNewsAdapter extends RecyclerView.Adapter<SecondNewsAdapter.ViewHolder>{
    private Context context;
    private List<SecondNewsItem> secondNewsItems;

    public SecondNewsAdapter(Context context, List<SecondNewsItem> secondNewsItems) {
        this.context = context;
        this.secondNewsItems = secondNewsItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_second_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SecondNewsItem secondNewsItem = secondNewsItems.get(position);
        holder.secondNewsTitleTextView.setText(secondNewsItem.getTitle());
        holder.secondNewsDescriptionTextView.setText(secondNewsItem.getDescription());
        holder.secondNewsImageView.setImageResource(secondNewsItem.getImageResource());
    }

    @Override
    public int getItemCount() {
        return secondNewsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView secondNewsImageView;
        TextView secondNewsTitleTextView;
        TextView secondNewsDescriptionTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            secondNewsImageView = itemView.findViewById(R.id.secondNewsImageView);
            secondNewsTitleTextView = itemView.findViewById(R.id.secondNewsTitleTextView);
            secondNewsDescriptionTextView = itemView.findViewById(R.id.secondNewsDescriptionTextView);
        }

    }

}
