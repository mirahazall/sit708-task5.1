package com.example.newsapp;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class NewsDetailFragment extends Fragment {

    private ImageView newsDetailImageView;
    private TextView newsDetailDescriptionTextView;
    private TextView newsDetailTitleTextView;
    private TextView newsDetailsTextView;
    private TextView relatedNewsDescriptionTextView;
    private RecyclerView relatedNewsRecyclerView;
    private RelatedNewsAdapter relatedNewsAdapter;
    private Button closeButton;
    private List<RelatedNewsItem> relatedNewsItems;

    public NewsDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        // Initialize views
        newsDetailImageView = view.findViewById(R.id.newsDetailImageView);
        newsDetailDescriptionTextView = view.findViewById(R.id.newsDetailDescriptionTextView);
        newsDetailTitleTextView = view.findViewById(R.id.newsDetailTitleTextView);
        newsDetailsTextView = view.findViewById(R.id.newsDetailsTextView);
        relatedNewsRecyclerView = view.findViewById(R.id.relatedNewsRecyclerView);
        closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Navigate back to the main activity
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        // Load news image and description from arguments
        Bundle bundle = getArguments();
        if (bundle != null) {
            int newsImageRes = bundle.getInt("newsImageRes");
            String newsTitle = bundle.getString("newsTitle");
            String newsDescription = bundle.getString("newsDescription");
            String newsDetails = bundle.getString("newsDetails");

            newsDetailImageView.setImageResource(newsImageRes);
            newsDetailTitleTextView.setText(newsTitle);
            newsDetailDescriptionTextView.setText(newsDescription);
            newsDetailsTextView.setText(newsDetails);
        }

        // Initialize and set up related news RecyclerView
        relatedNewsItems = getRelatedNewsItems(); // Method to get related news items
        relatedNewsAdapter = new RelatedNewsAdapter(getContext(), relatedNewsItems);
        relatedNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        relatedNewsRecyclerView.setAdapter(relatedNewsAdapter);

        return view;
    }

    // Method to get related news items
    private List<RelatedNewsItem> getRelatedNewsItems() {
        List<RelatedNewsItem> relatedNewsItems = new ArrayList<>();
        relatedNewsItems.add(new RelatedNewsItem("Russian athletes not part of Olympics ceremony", "The International Olympics Committee says Russian athletes won't be part of the parade of athletes in Paris.", R.drawable.olympicssign));
        relatedNewsItems.add(new RelatedNewsItem("Aussie Olympic champion announces retirement", "Gold medal-winning swimmer Mack Horton has announced his retirement from the sport.", R.drawable.swimmers));
        relatedNewsItems.add(new RelatedNewsItem("How Nine will cover the Olympic Games", "Nine has revealed plans for 24-hour coverage across metropolitan and regional TV.", R.drawable.runners));
        return relatedNewsItems;
    }
}

