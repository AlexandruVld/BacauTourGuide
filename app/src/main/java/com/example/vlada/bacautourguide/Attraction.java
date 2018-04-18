package com.example.vlada.bacautourguide;

public class Attraction {

    private String mDescription;
    private String mTitle;
    private int mImageResourceId;


     //Create a new object.

    public Attraction(String title, String description, int imageResourceId) {
        mTitle = title;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }
}

