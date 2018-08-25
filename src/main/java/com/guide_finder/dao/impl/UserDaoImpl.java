//package com.guide_finder.dao.impl;
//
////import com.guide_finder.dao.abstraction.UserDao;
//import com.guide_finder.model.contact.SocialContact;
//import com.guide_finder.model.user.Role;
//import com.guide_finder.model.user.Sex;
//import com.guide_finder.model.user.User;
//import com.guide_finder.util.DBHelper;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.*;
//
///**
//* Author - Vitaliy Polyvyanov
//* */
//
//public class UserDaoImpl implements UserDao {
//
//    private final Connection connection;
//
//    public UserDaoImpl() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
//        this.connection = DBHelper.getConnection();
//    }
//
//    @Override
//    public void saveUser(String password, String email, String firstName, String lastName, String phone, int age, String sex) {
//        try (Statement statement = connection.createStatement()) {
//            String sql_user = String.format("insert into user (password, email, firstname, lastname, phone, age, sex) " +
//                    "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s')", password, email, firstName, lastName, phone, age, sex);
//            statement.execute(sql_user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void saveDefaultRole(long userId) {
//        try (Statement stmt = connection.createStatement()) {
//            String sql = String.format("insert into user_role (user_id, role_id) VALUES ('%s','1')", userId);
//            stmt.execute(sql);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    @Override
//    public User getUserById(long userId) {
//        User user = null;
//        try (Statement stmt = connection.createStatement()) {
//            String sql = String.format("SELECT * FROM user where id='%s'", userId);
//            String sql_roles = String.format("SELECT rl.id, rl.name FROM " +
//                                                 "(SELECT role_id FROM user_role where user_id = '%s' ) as ur " +
//                                                    "JOIN role as rl ON ur.role_id = rl.id", userId);
//
//            stmt.execute(sql);
//            try (ResultSet result = stmt.getResultSet()) {
//                if (result.next()) {
//                    user = new User(
//                            result.getLong(1),                   //id
//                            result.getString(2),                //name
//                            result.getString(3),                //lastname
//                            result.getString(4),                //email
//                            result.getString(5),                //password
//                            result.getString(6),                //phone
//                            result.getInt(7),                   //age
//                            Sex.valueOf(result.getString(8)),   //sex
//                            null              //city
//                    );
//                }
//            } catch (SQLException e) {
//                System.out.println("Error: " + e);
//            }
//            stmt.execute(sql_roles);
//            getRole(user, stmt);
//        } catch (SQLException e) {
//            System.out.println("Error: " + e);
//        }
//        return user;
//    }
//
//    @Override
//    public User getUserByEmail(String email) {
//        User user = null;
//        try (Statement stmt = connection.createStatement()) {
//            String sql = String.format("SELECT * FROM user where email='%s'", email);
//            String sql_roles = String.format("SELECT rl.id, rl.name FROM " +
//                    "(SELECT role_id FROM user_role where user_id IN (SELECT id FROM user WHERE email='%s')) as ur " +
//                    "JOIN role as rl ON ur.role_id = rl.id", email);
//
//            stmt.execute(sql);
//            try (ResultSet result = stmt.getResultSet()) {
//                if (result.next()) {
//                    user = new User(
//                            result.getLong(1),                   //id
//                            result.getString(2),                //name
//                            result.getString(3),                //lastname
//                            result.getString(4),                //email
//                            result.getString(5),                //password
//                            result.getString(6),                //phone
//                            result.getInt(7),                   //age
//                            Sex.valueOf(result.getString(8)),   //sex
//                            null              //city
//                    );
//                }
//            } catch (SQLException e) {
//                System.out.println("Error: " + e);
//            }
//
//            stmt.execute(sql_roles);
//            getRole(user, stmt);
//        } catch (SQLException e) {
//            System.out.println("Error: " + e);
//        }
//        return user;
//    }
//
//    private void getRole(User user, Statement stmt) {
//        try (ResultSet result = stmt.getResultSet()) {
//            Set<Role> roles = new HashSet<>();
//            while (result.next()) {
//                roles.add(new Role(result.getLong(1), result.getString(2)));
//            }
//            Objects.requireNonNull(user).setRoles(roles);
//        } catch (SQLException e) {
//            System.out.println("Error: " + e);
//        }
//    }
//
//    @Override
//    public long getIdByEmail(String email) {
//        try (Statement stmt = connection.createStatement()) {
//            String sql = String.format("select id from user where email = '%s'", email);
//            stmt.execute(sql);
//            try (ResultSet result = stmt.getResultSet()) {
//                result.next();
//                return result.getLong(1);
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return 0;
//    }
//
//    @Override
//    public void editUser(User user) {
//        try(Statement stmt = connection.createStatement()){
//            String sql = String.format("UPDATE user SET firstname='%s', lastname='%s', email='%s', password='%s', phone='%s', age='%s', sex='%s' WHERE id='%s",
//                    user.getFirstName(), user.getLastName(), user.getPassword(), user.getPhone(), user.getEmail(), user.getAge(), user.getSex(), user.getId());
//            stmt.execute(sql);
//        }catch (SQLException e){
//            System.out.println(e);
//        }
//
//    }
//
//    @Override
//    public void deleteUser(long userId) {
//        try(Statement stmt = connection.createStatement()){
//            String sql = String.format("delete from user where id = '%s'", userId);
//            stmt.execute(sql);
//        }catch (SQLException e){
//            System.out.println(e);
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        User user;
//        List<User> list = new ArrayList<>();
//        try (Statement statement = connection.createStatement()) {
//            String ifaAllIsNull = "select * from user";
//            statement.execute(ifaAllIsNull);
//            try (ResultSet result = statement.getResultSet()) {
//                while (result.next()) {
//                    user = new User(
//                            result.getLong(1),                                //id
//                            result.getString(2),                              //name
//                            result.getString(3),                              //lastname
//                            result.getString(4),                              //email
//                            result.getString(5),                              //password
//                            result.getString(6),                              //phone
//                            result.getInt(7),                                 //age
//                            Sex.valueOf(result.getString(8).toUpperCase()),   //sex
//                            null
//                    );
//                    list.add(user);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public SocialContact getSocialContactsById(long id){
//
////        List<String> listOfContacts = new ArrayList<>();
//
//        SocialContact contact = null;
//
//        try(Statement statement = connection.createStatement()){
//            String sql = String.format("select * from socialcontact where user_id='%s'", id);
//            statement.executeQuery(sql);
//
//            ResultSet resultSet = statement.getResultSet();
//                resultSet.next();
//                String vk_profile = resultSet.getString(2);
//                String ok_profile = resultSet.getString(3);
//                String fb_profie = resultSet.getString(4);
//                String tg_profile = resultSet.getString(5);
//            contact = new SocialContact(vk_profile, ok_profile, fb_profie, tg_profile);
//        }catch (SQLException e) {
//            System.out.println(e);
//        }
//        return contact;
//    }
//}
