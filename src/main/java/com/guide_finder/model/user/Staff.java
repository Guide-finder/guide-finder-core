package com.guide_finder.model.user;

import com.guide_finder.model.enumiration.Sex;


public class Staff extends User {

    private long id;

    private int fix_price;


    public Staff(String login, String firstName, String lastName, String password, int age, Sex sex, String phone, String email, int fix_price) {
        super(login, firstName, lastName, password, age, sex, phone, email);
        this.fix_price = fix_price;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public int getFix_price() {
        return fix_price;
    }

    public void setFix_price(int fix_price) {
        this.fix_price = fix_price;
    }
}
