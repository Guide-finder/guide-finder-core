package com.guide_finder.service.abstraction.user;

import com.guide_finder.model.contact.SocialContact;
import com.guide_finder.model.user.Role;
import com.guide_finder.model.user.Sex;
import com.guide_finder.model.user.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    void saveUser(User user);

    User getUserById(long id);

    User getUserByEmail(String email);

    long getIdByEmail(String email);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    public List<User> getAllUsers(String city);

    public SocialContact getSocialContactsById(long id);

}
