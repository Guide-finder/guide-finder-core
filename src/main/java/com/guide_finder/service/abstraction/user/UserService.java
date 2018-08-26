package com.guide_finder.service.abstraction.user;

import com.guide_finder.dto.UserCoordsDto;
import com.guide_finder.model.user.User;

import java.util.List;

public interface UserService {

    long saveUser(User user);

    User getUserById(long id);

    User getUserByEmail(String email);

    long getIdByEmail(String email);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    void setCoord(long userId, double latitude, double longitude);

    List<Double> getCoord(long id);

    List<UserCoordsDto> getGuidesAround(Double longitude, Double latitude);

}
