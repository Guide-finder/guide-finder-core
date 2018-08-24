package com.guide_finder.model.user;

import java.util.Objects;
import java.util.Set;

import com.guide_finder.model.category.Category;
import com.guide_finder.model.contact.SocialContact;
import com.guide_finder.model.location.City;

public class Guide extends User{

    private String description;

    private City city;

    private Set<Language> languages;

    private Set<Category> categories;

    private Set<SocialContact> socialContacts;

    public Guide(){};

    public Guide(long id, String firstName, String lastName, String email, String password,
                 String phone, int age, Sex sex, Set<Role> roles) {
        super(id, firstName, lastName, email, password, phone, age, sex, roles);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Guide guide = (Guide) o;
        return Objects.equals(description, guide.description) &&
                Objects.equals(city, guide.city) &&
                Objects.equals(languages, guide.languages) &&
                Objects.equals(categories, guide.categories) &&
                Objects.equals(socialContacts, guide.socialContacts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), description, city, languages, categories, socialContacts);
    }
}
