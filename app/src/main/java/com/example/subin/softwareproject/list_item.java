package com.example.subin.softwareproject;

/**
 * Created by subin on 2017. 4. 21..
 */

import android.graphics.drawable.Drawable;

public class list_item {
    private String txt;
    private Drawable img;

    public void setText(String str){

        txt = str;

    }
    public void setImage(Drawable _img){
        img = _img;
    }
    public String getText(){
        return this.txt;
    }
    public Drawable getImage(){
        return this.img;
    }
}
