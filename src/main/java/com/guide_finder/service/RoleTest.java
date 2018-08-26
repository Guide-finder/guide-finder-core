package com.guide_finder.service;
//package java.com.guide_finder.service.role;


import com.guide_finder.model.user.Role;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.service.impl.RoleServiceImpl;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class RoleTest {

    RoleService roleService = new RoleServiceImpl();


    @Test
    public void testSaveRole() {

     long roleId = roleService.saveRole("SUPERUSER");

        assertEquals("Unexpected role name in saveRole method","SUPERUSER", roleService.getRoleById(roleId).getName());

    }

/*    @Test
    Role testGetRoleById(long id) {
        Role role = new Role();
    }

    @Test
    Role testGetRoleByName(String name) {

    }

    @Test
    void testEditRole(long id, String name) {

    }

    void testDeleteRole(long id) {

    }

    List<Role> testGetAllRoles() {

    }

    Set<Role> testGetAllRolesByUserId(long userId) {

    }*/

}
