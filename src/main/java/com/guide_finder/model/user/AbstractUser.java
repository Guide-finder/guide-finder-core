package model.user;


import java.util.Set;

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
    private Set<Role>

    public AbstractUser(int id, String firstname, String lastname, String password, String phone, String email, String sex, int age, Language language) {
    }

}
