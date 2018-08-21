package model.user;

public class User extends AbstractUser {

    public User(int id, String firstname, String lastname, String password,
                String phone, String email, String sex, int age, model.User.ROLE role) {
        super(id, firstname, lastname, password, phone, email, sex, age);
    }

}
