package com.xdwin.ukm101.homescreen;

import java.io.Serializable;

/**
 * Created by Edwin on 9/16/2016.
 */
public class HomeMenuModel implements Serializable {
    private int id;
    private String title;
    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

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
}
