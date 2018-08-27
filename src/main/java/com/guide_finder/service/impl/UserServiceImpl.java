package com.guide_finder.service.impl;

import com.guide_finder.dao.abstraction.user.UserDao;
import com.guide_finder.dao.impl.user.UserDaoImpl;
import com.guide_finder.model.contact.SocialContact;
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
    public long saveUser(User user) {
    return userDao.saveUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public long getIdByEmail(String email) {
        return userDao.getIdByEmail(email);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getAllUsers(String city) {
        return userDao.getAllUsers(city);
    }

    @Override
    public SocialContact getSocialContactsById(long id) {
        return userDao.getSocialContactsById(id);
    }

    @Override
    public List<User> getUsersByRole(int role_id) {
        return userDao.getUsersByRole(role_id);
    }

    @Override
    public Boolean setRoleToUser(long user_id, long role_id) {
        return userDao.setRoleToUser(user_id, role_id);
    }

    @Override
    public void costilToDescription(long user_id) {
        userDao.costilToDescription(user_id);
    }
}
