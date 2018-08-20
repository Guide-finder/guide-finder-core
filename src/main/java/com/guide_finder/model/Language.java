package com.guide_finder.model;

import com.guide_finder.model.enumiration.Levels;
import com.guide_finder.model.user.Guide;

import java.util.Set;


public class Language {

    private long id;

    private Language name;

    private Levels levels;

    private Set<Guide> guides;

    public Language(Language name, Levels levels, Set<Guide> guides) {
        this.name = name;
        this.levels = levels;
        this.guides = guides;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Language getName() {
        return name;
    }

    public void setName(Language name) {
        this.name = name;
    }

    public Levels getLevels() {
        return levels;
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }

    public Set<Guide> getGuides() {
        return guides;
    }

    public void setGuides(Set<Guide> guides) {
        this.guides = guides;
    }
}
