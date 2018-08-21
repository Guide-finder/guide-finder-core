package com.guide_finder.model.user;

public class Stuff extends AbstractUser {

    private Role role;

    public Stuff(int id, String firstName, String lastName, String password, String phone,
        String email, String sex, int age, Language language) {
        super(id, firstName, lastName, password, phone, email, sex, age, language);
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

}
