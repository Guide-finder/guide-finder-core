package model.user;

public class Stuff extends AbstractUser{

    private Role role;

    public Stuff(int id, String firstname, String lastname, String password, String phone, String email, String sex, int age) {
        super(id, firstname, lastname, password, phone, email, sex, age);
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

}
