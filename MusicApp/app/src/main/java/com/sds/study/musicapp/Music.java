package com.sds.study.musicapp;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by efro2 on 2016-11-11.
 */

public class Music{
    private String title;
    private String artist;
    private String filename;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
