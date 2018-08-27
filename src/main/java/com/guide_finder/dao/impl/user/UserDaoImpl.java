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
    public long saveUser(User user) {

        //todo не сохраняются роли в базу

        long user_id = executor.execUpdateWithKeys(String.format("insert into user (password, email, firstname, lastname, phone, age, sex) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s')", user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getAge(), user.getSex()));
        if (user_id > 0) {
            executor.execUpdate(String.format("insert into user_role (user_id, role_id) values ('%s', '%s')", user_id, 2));
        }
        return user_id;
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
        executor.execUpdate(String.format("UPDATE user SET firstname='%s', lastname='%s', email='%s', password='%s'," +
                                            " phone='%s', age='%s', sex='%s' WHERE id='%s'",
                                            user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
                                            user.getPhone(), user.getAge(), user.getSex(), user.getId()));
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
@Override
public void getUser(ResultSet result, List<User> urList) throws SQLException {
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
                            Sex.valueOf(result.getString(8).toUpperCase())  //sex
                    ));
        }
    }

    @Override
    public List<User> getUsersByRole(int role_id) {

            String getUserIdFromRoles = String.format("SELECT * FROM user WHERE id IN (SELECT user_id FROM user_role WHERE role_id= %s)", role_id);
            return executor.execQuery(getUserIdFromRoles, res -> {
                List<User> list = new ArrayList<>();
                getUser(res, list);
               return list;
            });
    }

    @Override
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


    /**
     * Author Dikobob
     * add role to user, if user has that role already - throw FALSE
     */
    public Boolean setRoleToUser(long user_id, long role_id) {
        return executor.execQuery("SELECT * FROM user_role WHERE user_id = " + user_id, res -> {
            boolean flag = false;
            while (res.next()) {
                if (res.getLong(2) == role_id) {
                    flag = true;
                }
            }
            if (!flag){
                executor.execUpdate(String.format("INSERT INTO user_role (user_id, role_id) VALUE (%s, %s)", user_id, role_id));
                return true;
            }
            else {
                return false;
            }
        });
    }

    public void costilToDescription(long user_id){
        executor.execUpdate(String.format("INSERT INTO guide (user_id, city_id, description) VALUE (%s, NULL, NULL )", user_id));
    }

    public List<User> usersBySearch(String city_id, List<String> language_id, String category) {
//        String lang = language_id.toString();
        List<User> list = new ArrayList<>();

        if (language_id == null){
            return executor.execQuery(String.format("SELECT * FROM user WHERE (id IN (SELECT user_id FROM guide WHERE city_id = %s))\n" +
                    "                        AND\n" +
                    "                        (id IN (SELECT user_id FROM user_category WHERE category_id IN (\n" +
                    "                          SELECT id FROM category WHERE name = \'%s\'\n" +
                    "                        )))", city_id, category), result -> {
                getUser(result, list);
                return list;
        });
        }
        else {
                String str = String.format("SELECT * FROM user WHERE (id IN (SELECT user_id FROM guide WHERE city_id = %s))\n" +
                        "                        AND\n" +
                        "                        (id IN (SELECT user_id FROM user_language WHERE language_id IN (%s)))\n" +
                        "                        AND\n" +
                        "                        (id IN (SELECT user_id FROM user_category WHERE category_id IN (\n" +
                        "                          SELECT id FROM category WHERE name = \'%s\'\n" +
                        "                        )))", city_id, language_id.toString(), category);
            str = str.replace("[", "");
            str = str.replace("]", "");
            System.out.println(str);
                return executor.execQuery(str, result -> {
                    getUser(result, list);
                    return list;
                });
            }
    }

    @Override
    public void editCustomUserOptions(long user_id, String city_id, List<String> languages, List<String> categories, List<String> roles) {
        executor.execUpdate("DELETE FROM user_category WHERE user_id = " + user_id + ";");
        executor.execUpdate("DELETE FROM user_language WHERE user_id = " + user_id + ";");
        executor.execUpdate("DELETE FROM user_role WHERE user_id = " + user_id + ";");
        executor.execUpdate("DELETE FROM guide WHERE user_id = " + user_id + ";");

        executor.execUpdate(String.format("INSERT INTO guide (user_id, city_id) VALUE (%s, %s);", user_id, city_id));
        if (languages != null) {
            for (String list : languages) {
                executor.execUpdate(String.format("INSERT INTO user_language (user_id, language_id) VALUE (%s, %s);\n", user_id, list).replace("[", "").replace("]", ""));
            }
        }
        if (categories != null) {
            for (String list : categories) {
                executor.execUpdate(String.format("INSERT INTO user_category (user_id, category_id) VALUE (%s, %s);\n", user_id, list).replace("[", "").replace("]", ""));
            }
        }
        if (roles != null) {
            for (String list : roles) {
                executor.execUpdate(String.format("INSERT INTO user_role (user_id, role_id) VALUE (%s, %s);\n", user_id, list).replace("[", "").replace("]", ""));
            }
        }
    }
}
