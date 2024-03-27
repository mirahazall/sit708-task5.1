package com.example.newsapp;

// Import necessary packages
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    private List<NewsItem> newsItems;
    private OnItemClickListener listener;

    public NewsAdapter(Context context, List<NewsItem> newsItems, OnItemClickListener listener) {
        this.context = context;
        this.newsItems = newsItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NewsItem newsItem = newsItems.get(position);
        holder.newsTitleTextView.setText(newsItem.getTitle());
        holder.newsDetailsTextView.setText(newsItem.getNewsDetails());
        holder.newsDescriptionTextView.setText(newsItem.getDescription());
        holder.newsImageView.setImageResource(newsItem.getImageResource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(newsItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImageView;
        TextView newsTitleTextView;
        TextView newsDescriptionTextView;
        TextView newsDetailsTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.newsImageView);
            newsTitleTextView = itemView.findViewById(R.id.newsTitleTextView);
            newsDescriptionTextView = itemView.findViewById(R.id.newsDescriptionTextView);
            newsDetailsTextView = itemView.findViewById(R.id.newsDetailsTextView);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(NewsItem newsItem);
    }
}


