package com.guide_finder.model.user;

public class Stuff extends AbstractUser {

    private double salary;

    public Stuff(String firstName, String lastName, String password, String phone, String email,
        double salary) {
        super(firstName, lastName, password, phone, email);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
