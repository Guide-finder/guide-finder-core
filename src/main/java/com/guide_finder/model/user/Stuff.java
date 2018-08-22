package com.guide_finder.model.user;

import java.util.Objects;

public class Stuff {

    private double salary;

//    public Stuff(String firstName, String lastName, String password, String phone, String email,
//        double salary) {
//        super(firstName, lastName, password, phone, email);
//        this.salary = salary;
//    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Stuff stuff = (Stuff) o;
        return Double.compare(stuff.salary, salary) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), salary);
    }
}
