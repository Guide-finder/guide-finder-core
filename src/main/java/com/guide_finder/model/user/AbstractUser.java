package com.guide_finder.model.user;


import java.util.Set;

import com.guide_finder.model.user.Language;
import com.guide_finder.model.user.Role;

public abstract class AbstractUser {

    private int id;

    private String firstname;

    private String lastname;

    private String password;

    private String phone;

    private String email;

    private String sex;

    private int age;

    private Language language;

    public AbstractUser(int id, String firstname, String lastname, String password, String phone,
        String email, String sex, int age, Language language) {
    }

}
