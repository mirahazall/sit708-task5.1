package com.example.newsapp;

public class NewsItem {
    private String title;
    private String description;
    private String newsDetails;
    private int imageResource;

    public NewsItem(String title, String description, String newsDetails, int imageResource) {
        this.title = title;
        this.description = description;
        this.newsDetails = newsDetails;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getNewsDetails() {
        return newsDetails;
    }
    public int getImageResource() {
        return imageResource;
    }
}

