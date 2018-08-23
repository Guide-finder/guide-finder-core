package com.guide_finder.dao.impl.user;

import com.guide_finder.dao.abstraction.user.UserDao;
import com.guide_finder.dao.executor.Executor;
import com.guide_finder.model.user.Role;
import com.guide_finder.model.user.Sex;
import com.guide_finder.model.user.User;

import java.sql.Connection;
import java.util.*;

/**
* Author - Vitaliy Polyvyanov
* */

public class UserDaoImpl implements UserDao {

    private final Executor executor;

    public UserDaoImpl(Connection connection){
        this.executor = new Executor(connection);
    }

    @Override
    public void saveUser(User user) {
        executor.execUpdate(String.format("insert into user (password, email, firstname, lastname, phone, age, sex) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s')", user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getAge(), user.getSex()));
    }

    @Override
    public void saveDefaultRole(long userId) {
        executor.execUpdate(String.format("insert into user_role (user_id, role_id) VALUES ('%s','1')", userId));
    }

    @Override
    public User getUserById(long userId) {
        return executor.execQuery(String.format("SELECT * FROM user where id='%s'", userId), result -> {
            result.next();
            return new User(
                    result.getLong(1),                  //id
                    result.getString(2),                //firstName
                    result.getString(3),                //lastName
                    result.getString(4),                //email
                    result.getString(5),                //password
                    result.getString(6),                //phone
                    result.getInt(7),                   //age
                    Sex.valueOf(result.getString(8)),   //sex
                    new HashSet<>(
                            executor.execQuery(String.format("SELECT * FROM role WHERE id IN (SELECT role_id FROM user_role WHERE user_id IN (SELECT id FROM user WHERE id = '%s'))", userId),
                                    result_role ->{
                                        Set<Role> roles = new HashSet<>();
                                        while(result_role.next()){
                                            roles.add(
                                                    new Role(
                                                            result_role.getLong(1),
                                                            result_role.getString(2)
                                                    )
                                            );
                                        }
                                        return roles;
                                    }))                             // role
            );

        });
    }

    @Override
    public User getUserByEmail(String email) {
        return executor.execQuery(String.format("SELECT * FROM user where email='%s'", email), result -> {
            result.next();
            return new User(
                    result.getLong(1),                  //id
                    result.getString(2),                //firstName
                    result.getString(3),                //lastName
                    result.getString(4),                //email
                    result.getString(5),                //password
                    result.getString(6),                //phone
                    result.getInt(7),                   //age
                    Sex.valueOf(result.getString(8)),   //sex
                    new HashSet<>(
                            executor.execQuery(String.format("SELECT * FROM role WHERE id IN (SELECT role_id FROM user_role WHERE user_id IN (SELECT id FROM user WHERE email = '%s'))", email),
                                    result_role ->{
                                        Set<Role> roles = new HashSet<>();
                                        while(result_role.next()){
                                            roles.add(
                                                    new Role(
                                                            result_role.getLong(1),
                                                            result_role.getString(2)
                                                    )
                                            );
                                        }
                                return roles;
                            }))                                     // role
            );
        });
    }

    @Override
    public long getIdByEmail(String email) {
        return executor.execQuery(String.format("select id from user where email = '%s'", email), result -> {
            result.next();
            return result.getLong(1);
        });
    }

    @Override
    public void editUser(User user) {
        executor.execUpdate(String.format("UPDATE user SET firstname='%s', lastname='%s', email='%s', password='%s', phone='%s', age='%s', sex='%s' WHERE id='%s'",
                    user.getFirstName(), user.getLastName(), user.getPassword(), user.getPhone(), user.getEmail(), user.getAge(), user.getSex(), user.getId()));
    }

    @Override
    public void deleteUser(long userId) {
        executor.execUpdate(String.format("delete from user where id = '%s'", userId));
    }

    @Override
    public List<User> getAllUsers() {
        return executor.execQuery("select * from user", result -> {
            List<User> urList = new ArrayList<>();
            while (result.next()) {
                urList.add(
                        new User(
                                result.getLong(1),                                //id
                                result.getString(2),                              //firstName
                                result.getString(3),                              //lastName
                                result.getString(4),                              //email
                                result.getString(5),                              //password
                                result.getString(6),                              //phone
                                result.getInt(7),                                 //age
                                Sex.valueOf(result.getString(8).toUpperCase()),   //sex
                                new HashSet<>(
                                        executor.execQuery(String.format("SELECT * FROM role WHERE id IN (SELECT role_id FROM user_role WHERE user_id IN (SELECT id FROM user WHERE id = '%s'))", result.getLong(1)),
                                                result_role ->{
                                                    Set<Role> roles = new HashSet<>();
                                                    while(result_role.next()){
                                                        roles.add(
                                                                new Role(
                                                                        result_role.getLong(1),
                                                                        result_role.getString(2)
                                                                )
                                                        );
                                                    }
                                                    return roles;
                                                }))                                            // role
                        ));
            }
            return urList;
        });
    }
}
