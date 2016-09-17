package com.xdwin.ukm101.marketing;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Edwin on 9/14/2016.
 */
public class MarketingEndorserModel implements Serializable {

    private int id;
    private String name;
    private String imageUrl;
    private String channel;
    private String description;
    private String rangePrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRangePrice() {
        return rangePrice;
    }

    public void setRangePrice(String rangePrice) {
        this.rangePrice = rangePrice;
    }
}
