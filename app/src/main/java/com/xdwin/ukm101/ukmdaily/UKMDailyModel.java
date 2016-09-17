package com.xdwin.ukm101.ukmdaily;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by Edwin on 9/11/2016.
 */
public class UKMDailyModel implements Serializable {
    private int id;
    private String title;
    private String excerpt;
    private String content;
    private long timestamp;
    private String imageURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
