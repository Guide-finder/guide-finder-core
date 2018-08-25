package com.guide_finder.dao.impl.user;

import com.guide_finder.dao.abstraction.user.UserDao;
import com.guide_finder.dao.executor.Executor;
import com.guide_finder.model.contact.SocialContact;
import com.guide_finder.model.user.Role;
import com.guide_finder.model.user.Sex;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.impl.RoleServiceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
* Author - Vitaliy Polyvyanov
* */

public class UserDaoImpl implements UserDao {

    private final Executor executor;
    private final RoleService roleService = new RoleServiceImpl();

    public UserDaoImpl(Connection connection){
        this.executor = new Executor(connection);
    }

    @Override
    public void saveUser(User user) {

        //todo не сохраняются роли в базу

        long user_id = executor.execUpdateWithKeys(String.format("insert into user (password, email, firstname, lastname, phone, age, sex) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s')", user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getAge(), user.getSex()));
        if (user_id > 0) {
            executor.execUpdate(String.format("insert into user_role (user_id, role_id) values ('%s', '%s')", user_id, 2));
        }
    }

    @Override
    public User getUserById(long userId) {
        User user =  executor.execQuery(String.format("SELECT * FROM user where id='%s'", userId), result -> {
            result.next();

            return new User(
                    result.getLong(1),                  //id
                    result.getString(2),                //firstName
                    result.getString(3),                //lastName
                    result.getString(4),                //email
                    result.getString(5),                //password
                    result.getString(6),                //phone
                    result.getInt(7),                   //age
                    Sex.valueOf(result.getString(8))
            );  //sex)

        });

        Set<Role> roles = roleService.getAllRolesByUserId(userId);

        user.setRoles(roles);

        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        User user =  executor.execQuery(String.format("SELECT * FROM user where email='%s'", email), result -> {
            result.next();

            return new User(
                    result.getLong(1),                  //id
                    result.getString(2),                //firstName
                    result.getString(3),                //lastName
                    result.getString(4),                //email
                    result.getString(5),                //password
                    result.getString(6),                //phone
                    result.getInt(7),                   //age
                    Sex.valueOf(result.getString(8))
            );  //sex)

        });

        if (user != null) {
            Set<Role> roles = roleService.getAllRolesByUserId(user.getId());
            user.setRoles(roles);
        }

        return user;
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
            getUser(result, urList);
            return urList;
        });
    }

    @Override
    public List<User> getAllUsers(String city) {
        if (city.equals("")){
            return getAllUsers();
        }else {
            return executor.execQuery(String.format("select * from user where id IN " +
                    " (select user_id from guide where city_id IN " +
                    " (select id from city where name = '%s'))", city), result -> {
                List<User> urList = new ArrayList<>();
                getUser(result, urList);
                return urList;
            });
        }
    }

    private void getUser(ResultSet result, List<User> urList) throws SQLException {
        while (result.next()) {
            urList.add(
                    new User(
                            result.getLong(1),                                //id
                            result.getString(2),                              //firstName
                            result.getString(3),                              //lastName
                            result.getString(4),                              //phone
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
    }

    public SocialContact getSocialContactsById(long id){
        SocialContact contact = null;

        return executor.execQuery(String.format("select * from socialcontact where user_id='%s'", id), result ->{
            result.next();
            return new SocialContact(result.getString(2),result.getString(3),
                                    result.getString(4),result.getString(5));
                }
        );

//        try(Statement statement = connection.createStatement()){
//            String sql = String.format("select * from socialcontact where user_id='%s'", id);
//            statement.executeQuery(sql);
//
//            ResultSet resultSet = statement.getResultSet();
//            resultSet.next();
//            String vk_profile = resultSet.getString(2);
//            String ok_profile = resultSet.getString(3);
//            String fb_profie = resultSet.getString(4);
//            String tg_profile = resultSet.getString(5);
//            contact = new SocialContact(vk_profile, ok_profile, fb_profie, tg_profile);
//        }catch (SQLException e) {
//            System.out.println(e);
//        }
//        return contact;
//    }
    }

}
