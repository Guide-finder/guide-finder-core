package com.guide_finder.dao.abstraction.user;

import com.guide_finder.model.user.*;

import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    long saveUser(User user);

    User getUserById(long id);

    User getUserByEmail(String email);

    long getIdByEmail(String email);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    void getUser(ResultSet result, List<User> urList) throws SQLException;

    List<User> getUsersByRole(int role_id);

    List<User> getAllUsers(String city);

    Boolean setRoleToUser(long user_id, long role_id);

}
