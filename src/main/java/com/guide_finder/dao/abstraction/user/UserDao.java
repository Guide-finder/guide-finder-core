package com.guide_finder.dao.abstraction.user;

import com.guide_finder.model.contact.SocialContact;
import com.guide_finder.dto.UserCoordsDto;
import com.guide_finder.model.user.*;

import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    int getUserStateById(long id);

    long saveUser(User user);

    User getUserById(long id);

    User getUserByEmail(String email);

    long getIdByEmail(String email);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers(String city);

    void setCoord(long userId, double latitude, double longitude);

    List<Double> getCoord(long id);

    List<UserCoordsDto> getGuidesAround(Double latitude, Double longitude);

    List<User> usersBySearch(String city_id, List<String> language_id, String category);

    SocialContact getSocialContactsById(long id);

    void costilToDescription(long user_id);

    List<User> getUsersByRole(int role_id);

    void getUser(ResultSet result, List<User> urList) throws SQLException;

    Boolean setRoleToUser(long user_id, long role_id);

    List<User> getAllUsers();

    void setUserActive(int active, long user_id);

    void deleteUserCoord(long user_id);

}
