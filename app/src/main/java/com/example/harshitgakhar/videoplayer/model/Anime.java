package com.example.harshitgakhar.videoplayer.model;

/**
 * Created by harshit gakhar on 02-04-2019.
 */

public class Anime {

    private String desc;
    private String title;/// name
    private String thumbnail;//image_urll
    private int id;/////nb_episode
    private String url;


    public Anime() {
    }

    public Anime(String desc,String title, String thumbnail, int id, String url) {
        this.desc=desc;
        this.title = title;
        this.thumbnail = thumbnail;
        this.id = id;
        this.url = url;
    }

    public  String getDesc()
    {
        return desc;
    }
    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

public void setDesc(String desc)
{
    this.desc=desc;
}
    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
