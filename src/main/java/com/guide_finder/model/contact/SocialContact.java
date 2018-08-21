package com.guide_finder.model.contact;

public class SocialContact {

    private String link;

    private SocialContact type;

    public SocialContact(String link, SocialContact type) {
        this.link = link;
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public SocialContact getType() {
        return type;
    }

    public void setType(SocialContact type) {
        this.type = type;
    }
}
