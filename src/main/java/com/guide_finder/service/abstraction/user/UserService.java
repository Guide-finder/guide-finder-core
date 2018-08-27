package com.guide_finder.service.abstraction.user;

import com.guide_finder.model.contact.SocialContact;
import com.guide_finder.dto.UserCoordsDto;
import com.guide_finder.model.user.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    long saveUser(User user);

    User getUserById(long id);

    User getUserByEmail(String email);

    long getIdByEmail(String email);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers(String city);

    List<User> getAllUsers();

    void setCoord(long userId, double latitude, double longitude);

    SocialContact getSocialContactsById(long id);

    List<User> getUsersByRole(int role_id);

    List<Double> getCoord(long id);

    List<UserCoordsDto> getGuidesAround(Double longitude, Double latitude);

    Boolean setRoleToUser(long user_id, long role_id);

    List<User> usersBySearch(String city_id, List<String> language_id, String category);

    void costilToDescription(long user_id);

    void setUserActive(int active, long user_id);

    void deleteUserCoord(long user_id);
}
