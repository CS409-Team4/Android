package com.example.jangyoungsoo.iui_android;

public class CAItem {

    private String time;
    private String room;
    private String title;
    private Boolean fav;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getFav() {
        return fav;
    }

    public void setFav(Boolean fav) {
        this.fav = fav;
    }

    public CAItem(String time, String room, String title, Boolean fav){
        this.time = time;
        this.room = room;
        this.title = title;
        this.fav = fav;
    }
}
