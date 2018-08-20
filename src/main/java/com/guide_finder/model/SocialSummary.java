package com.guide_finder.model;



public class SocialSummary {

    private long id;

    private String vkontakte;

    private String facebook;

    public SocialSummary(String vk, String fb) {
        this.vkontakte = vk;
        this.facebook = fb;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVkontakte() {
        return vkontakte;
    }

    public void setVkontakte(String vkontakte) {
        this.vkontakte = vkontakte;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
}
