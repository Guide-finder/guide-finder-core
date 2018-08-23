package com.guide_finder.dao.abstraction.user;

import com.guide_finder.model.user.*;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void saveDefaultRole(long id);

    User getUserById(long id);

    User getUserByEmail(String email);

    long getIdByEmail(String email);

    void editUser(long id, String password, String email, String firstname, String lastname, String phone, int age, String sex);

    void deleteUser(long id);

    List<User> getAllUsers();

}
