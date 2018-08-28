package com.guide_finder.model.category;

import java.util.Objects;
import java.util.Set;

import com.guide_finder.model.user.Guide;
import com.guide_finder.util.TableAnnotation;

@TableAnnotation(name = "category")
public class Category {
    private long id;
    private String name;
    private String description;
    private String link;
    private Set<Guide> guides;

    public Category(String name, String description, String link) {
        this.name = name;
        this.description = description;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
