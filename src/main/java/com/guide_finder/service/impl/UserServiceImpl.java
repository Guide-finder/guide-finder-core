package com.guide_finder.service.impl;

import com.guide_finder.dao.abstraction.user.UserDao;
import com.guide_finder.dao.impl.user.UserDaoImpl;
import com.guide_finder.dto.UserCoordsDto;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
    public void saveUser(User user) {
         userDao.saveUser(user);
    }

    @Override
    public void saveDefaultRole(long id) {
        userDao.saveDefaultRole(id);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
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
    public void setCoord(long userId, double latitude, double longitude) {
        userDao.setCoord(userId, latitude, longitude);
    }


    public List<Double> getCoord(long id) {
        return userDao.getCoord(id);
    }

    @Override
    public List<UserCoordsDto> getGuidesAround(Double longitude, Double latitude) {
        return userDao.getGuidesAround(longitude, latitude);
    }
}
