package com.guide_finder.model;

import com.guide_finder.model.user.Guide;

import java.util.Set;


public class Category {

    private long id;

    private String name;

    private String description;

    private Set<Guide> guides;

    public Category(String name, String description, Set<Guide> guides) {
        this.name = name;
        this.description = description;
        this.guides = guides;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Guide> getGuides() {
        return guides;
    }

    public void setGuides(Set<Guide> guides) {
        this.guides = guides;
    }
}
