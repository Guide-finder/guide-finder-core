package com.guide_finder.service.abstraction.user;

import com.guide_finder.dto.UserCoordsDto;
import com.guide_finder.model.user.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void saveDefaultRole(long id);

    User getUserById(long id);

    long getIdByEmail(String email);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    void setCoord(long userId, double latitude, double longitude);

    List<Double> getCoord(long id);

    List<UserCoordsDto> getGuidesAround(Double longitude, Double latitude);

}
