package com.guide_finder.model.user;

import com.guide_finder.model.*;
import com.guide_finder.model.enumiration.Sex;
import com.guide_finder.model.user.User;

import java.util.List;
import java.util.Set;


public class Guide extends User {

    private long id;

    private boolean isActive;

    private String description;

    private int likeCount;

    private SocialSummary socialSummary;

    private Set<Language> languages;

    private List<Comment> comments;

    private Set<Category> categories;

    public Guide(String login, String firstName, String lastName, String password, int age, Sex sex, String phone, String email) {
        super(login, firstName, lastName, password, age, sex, phone, email);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public SocialSummary getSocialSummary() {
        return socialSummary;
    }

    public void setSocialSummary(SocialSummary socialSummary) {
        this.socialSummary = socialSummary;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
