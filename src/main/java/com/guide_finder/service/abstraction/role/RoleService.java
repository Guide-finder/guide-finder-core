package com.guide_finder.service.abstraction.role;

import com.guide_finder.model.user.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    void saveRole(String name);

    Role getRoleById(long id);

    Role getRoleByName(String name);

    void editRole(long id, String name);

    void deleteRole(long id);

    List<Role> getAllRoles();

    Set<Role> getAllRolesByUserId(long userId);

}
