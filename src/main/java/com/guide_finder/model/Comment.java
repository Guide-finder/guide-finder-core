package com.guide_finder.model;


public class Comment {

    private long id;

    private long date;  //todo сделать дату объектом даты

    private String content;

    private boolean isLike;

    public Comment(long date, String content, boolean isLike) {
        this.date = date;
        this.content = content;
        this.isLike = isLike;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
