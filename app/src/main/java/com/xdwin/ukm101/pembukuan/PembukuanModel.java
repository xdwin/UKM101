package com.xdwin.ukm101.pembukuan;

import java.io.Serializable;

/**
 * Created by Edwin on 9/16/2016.
 */
public class PembukuanModel implements Serializable {
    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
