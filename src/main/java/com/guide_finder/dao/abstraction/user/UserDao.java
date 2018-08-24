package com.guide_finder.dao.abstraction.user;

import com.guide_finder.model.user.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void saveDefaultRole(long id);

    User getUserById(long id);

    long getIdByEmail(String email);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

}
