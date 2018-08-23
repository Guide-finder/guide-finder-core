package com.guide_finder.service.impl.user;

import com.guide_finder.dao.abstraction.user.UserDao;
import com.guide_finder.dao.impl.user.UserDaoImpl;
import com.guide_finder.model.user.Role;
import com.guide_finder.model.user.Sex;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl() {
        Connection connection = null;

        try {
            connection = DBHelper.getConnection();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        this.userDao = new UserDaoImpl(connection);
    }

    @Override
    public void saveUser(String firstName, String lastName, String password, String phone, String email, Sex sex, int age, Set<Role> roles) {
        //userDao.saveUser();
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public void editUser(long id) {

    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public List<?> getAllUsers() {
        return null;
    }
}
