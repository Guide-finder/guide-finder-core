package com.guide_finder.dao.abstraction.user;

import com.guide_finder.model.user.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserDao {

    void saveUser(User user);

    User getUserById(long id);

    User getUserByEmail(String email);

    long getIdByEmail(String email);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    List<User> getUsersByRole(int role_id, UserDao userDao);

    List<User> getAllUsers(String city);

}
