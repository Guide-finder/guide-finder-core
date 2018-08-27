package com.guide_finder.model.user;

import com.guide_finder.util.TableAnnotation;

import java.util.Objects;
import java.util.Set;

@TableAnnotation(name = "staff")
public class Stuff extends User {

    private double salary;

    public Stuff(long id, String firstName, String lastName, String email, String password,
                 String phone, int age, Sex sex, Set<Role> roles) {
        super(id, firstName, lastName, email, password, phone, age, sex, roles);
    }

    public Stuff(long id, String firstName, String lastName, String email, String password,
                 String phone, int age, Sex sex, Set<Role> roles, double salary) {
        super(id, firstName, lastName, email, password, phone, age, sex, roles);
        this.salary = salary;
    }


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
