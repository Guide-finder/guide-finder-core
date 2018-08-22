package com.guide_finder.service.abstraction;

import com.guide_finder.model.user.Role;
import com.guide_finder.model.user.Sex;
import com.guide_finder.model.user.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    void saveUser(String firstName, String lastName, String password, String phone, String email, Sex sex, int age, Set<Role> roles);

    User getUserById(long id);

    User getUserByName(String name);

    void editUser(long id);

    void deleteUser(long id);

    List<?> getAllUsers();

}
