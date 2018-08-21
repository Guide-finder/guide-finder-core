package com.guide_finder.model.user;

public class User extends AbstractUser {

    public User(int id, String firstName, String lastName, String password, String phone,
        String email, String sex, int age, Language language) {
        super(id, firstName, lastName, password, phone, email, sex, age, language);
    }

}
