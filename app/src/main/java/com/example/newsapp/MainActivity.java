package com.example.newsapp;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsAdapter.OnItemClickListener{

    private RecyclerView topStoriesRecyclerView;
    private RecyclerView secondNewsRecyclerView;
    private NewsAdapter newsAdapter;
    private SecondNewsAdapter secondNewsAdapter;
    private NewsDetailFragment newsDetailFragment;
    private RecyclerView newsRecyclerView;
    private TopStoriesAdapter adapter;
    private ImageButton previousButton;
    private ImageButton nextButton;
    private LinearLayoutManager layoutManager;
    private LinearLayoutManager newsLayoutManager;
    private LinearLayoutManager SecondNewsLayoutManager;
    private List<TopStory> topStories;
    private List<NewsItem> newsItems;
    private List<SecondNewsItem> secondNewsItems;
    private int currentItemIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        topStoriesRecyclerView = findViewById(R.id.topStoriesRecyclerView);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        newsRecyclerView = findViewById(R.id.newsRecyclerView);
        secondNewsRecyclerView = findViewById(R.id.secondNewsRecyclerView);

        // Create dummy data
        topStories = generateTopStories();

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topStoriesRecyclerView.setLayoutManager(layoutManager);
        newsLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        newsRecyclerView.setLayoutManager(newsLayoutManager);
        SecondNewsLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        secondNewsRecyclerView.setLayoutManager(SecondNewsLayoutManager);

        // Create adapter and set it to RecyclerView
        adapter = new TopStoriesAdapter(this, topStories);
        topStoriesRecyclerView.setAdapter(adapter);

        // Create dummy data for newsRecyclerView
        List<NewsItem> newsItems = generateNewsItems();

        NewsAdapter newsAdapter = new NewsAdapter(this, newsItems, this);
        newsRecyclerView.setAdapter(newsAdapter);


        List<SecondNewsItem> secondNewsItems = generateSecondNewsItems();
        SecondNewsAdapter secondNewsAdapter = new SecondNewsAdapter(this, secondNewsItems);
        secondNewsRecyclerView.setAdapter(secondNewsAdapter);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentItemIndex < topStories.size() - 1) {
                    currentItemIndex++;
                    topStoriesRecyclerView.smoothScrollToPosition(currentItemIndex);
                }
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentItemIndex > 0) {
                    currentItemIndex--;
                    topStoriesRecyclerView.smoothScrollToPosition(currentItemIndex);
                }
            }
        });
    }

    // Generate dummy data for top stories
    private List<TopStory> generateTopStories() {
        List<TopStory> topStories = new ArrayList<>();
        topStories.add(new TopStory("Story 1", "Description of Story 1", R.drawable.fakenews));
        topStories.add(new TopStory("Story 2", "Description of Story 2", R.drawable.newsphoto));
        topStories.add(new TopStory("Story 3", "Description of Story 3", R.drawable.business));
        topStories.add(new TopStory("Story 4", "Description of Story 4", R.drawable.inflation));
        topStories.add(new TopStory("Story 5", "Description of Story 5", R.drawable.newspaper));
        return topStories;
    }

    private List<NewsItem> generateNewsItems() {
        List<NewsItem> newsItems = new ArrayList<>();
        newsItems.add(new NewsItem("9NEWS", "Olympics decision revealed!", "Sports Minister revealed ‘robust’ discussion over Qld’s contentious Olympics decision. She expressed her view on the 2032 Brisbane Olympic stadium dilemma during a “robust” discussion after the Miles government’s controversial decision.",R.drawable.olympics));
        newsItems.add(new NewsItem("7NEWS", "Sleep Deprivation makes you feel older", "Two nights of broken sleep can make people feel years older, finds study. Beyond simply feeling decrepit, perception of being older can affect health by encouraging unhealthy eating and reducing exercise.", R.drawable.sleep));
        newsItems.add(new NewsItem("SKY NEWS", "Europe’s economy is under attack from all sides", "decade ago Xi Jinping was welcomed to Duisburg in Germany’s Ruhr valley. He praised the region as a hub for Chinese investment; greeted a train that had spent a fortnight travelling from Chongqing, via Russia, to Europe’s industrial belt.", R.drawable.europe));
        return newsItems;
    }

    private List<SecondNewsItem> generateSecondNewsItems() {
        List<SecondNewsItem> secondNewsItems = new ArrayList<>();
        secondNewsItems.add(new SecondNewsItem("ABC NEWS", "Baltimore bridge collapses", R.drawable.bridge));
        secondNewsItems.add(new SecondNewsItem("THE AGE", "Spiderman Returns", R.drawable.spiderman));
        secondNewsItems.add(new SecondNewsItem("CNN NEWS", "Riot in Alice Springs", R.drawable.alicesprings));
        return secondNewsItems;
    }

    @Override
    public void onItemClick(NewsItem newsItem) {
        ViewGroup rootView = findViewById(R.id.container);
        rootView.removeAllViews();
        // Show NewsDetailFragment when a news item is clicked
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("newsDetails", newsItem.getNewsDetails());
        bundle.putInt("newsImageRes", newsItem.getImageResource());
        bundle.putString("newsDescription", newsItem.getDescription());
        bundle.putString("newsTitle", newsItem.getTitle());
        newsDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, newsDetailFragment)
                .addToBackStack(null)
                .commit();
    }

}
