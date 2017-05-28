package com.example.jangyoungsoo.iui_android;

public class SLItem {

    private String title;
    private String content;
    private String summary;
    private Boolean fav;
    private Integer id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Boolean getFav() {
        return fav;
    }

    public void setFav(Boolean fav) {
        this.fav = fav;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SLItem(String title, String content, String summary, Boolean fav, Integer id){
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.fav = fav;
        this.id = id;
    }
}
