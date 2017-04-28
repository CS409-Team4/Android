package com.example.subin.softwareproject;

import java.util.ArrayList;

/**
 * Created by subin on 2017. 4. 22..
 */
import android.graphics.drawable.Drawable;

public class itemlayout_meta {

    private Drawable file_img;
    private String title;
    private String author;
    void setMetadata(Drawable file, String title, String author) {
        this.file_img = file;
        this.title = title;
        this.author = author;
    }
    public Drawable getFileimg(){return this.file_img;}
    public String getTitle(){return this.title;}
    public String getAuthor(){return this.author;}
}
