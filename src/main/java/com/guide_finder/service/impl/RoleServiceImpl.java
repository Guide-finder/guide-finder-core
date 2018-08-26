package com.guide_finder.service.impl;

import com.guide_finder.dao.abstraction.role.RoleDao;
import com.guide_finder.dao.impl.role.RoleDaoImpl;
import com.guide_finder.model.user.Role;
import com.guide_finder.service.abstraction.role.RoleService;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl() {
        Connection connection = null;

        try {
            connection = DBHelper.getConnection();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        this.roleDao = new RoleDaoImpl(connection);
    }


    @Override
    public long saveRole(String name) {
        return roleDao.saveRole(name);
    }

    @Override
    public Role getRoleById(long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public void editRole(long id, String name) {
        roleDao.editRole(id, name);
    }

    @Override
    public void deleteRole(long id) {
        roleDao.deleteRole(id);

    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Set<Role> getAllRolesByUserId(long userId) {
        return roleDao.getAllRolesByUserId(userId);
    }
}
