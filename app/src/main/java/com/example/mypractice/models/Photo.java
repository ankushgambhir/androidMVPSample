package com.example.mypractice.models;

import java.io.Serializable;

public class Photo implements Serializable {

    private String id;
    private int likes;
    private int favorites;
    private String tags;
    private String previewURL;
    private String webFormatURL;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getWebFormatURL() {
        return webFormatURL;
    }

    public void setWebFormatURL(String webFormatURL) {
        this.webFormatURL = webFormatURL;
    }
}
