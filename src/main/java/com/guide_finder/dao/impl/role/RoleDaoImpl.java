package com.guide_finder.dao.impl.role;

import com.guide_finder.dao.abstraction.role.RoleDao;
import com.guide_finder.dao.executor.Executor;
import com.guide_finder.model.user.Role;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleDaoImpl implements RoleDao {

    private final Executor executor;
    private final Connection connection;

    public RoleDaoImpl(Connection connection) {
        this.executor = new Executor(connection);
        this.connection = connection;
    }

    public void saveRole(String name) {
        try (Statement statement = connection.createStatement()) {
            String query = String.format("insert into role values ('%s')", name);
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role getRoleById(long id) {
        Role role = null;
        try (Statement statement = connection.createStatement()) {
            String query = String.format("select * from role where id='%s'", id);
            statement.execute(query);
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    role = new Role(
                            resultSet.getLong(1),
                            resultSet.getString(2)
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public Role getRoleByName(String name) {
        Role role = null;
        try (Statement statement = connection.createStatement()) {
            String query = String.format("select * from role where name='%s'", name);
            statement.execute(query);
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    role = new Role(
                            resultSet.getLong(1),
                            resultSet.getString(2)
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void editRole(long id, String name) {
        try (Statement statement = connection.createStatement()) {
            String query = String.format("update role set name='%s' where id='%s'", name, id);
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRole(long id) {
        try (Statement statement = connection.createStatement()) {
            String query = String.format("delete from role where id='%s'", id);
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> getAllRoles() {
        Role role;
        List list = new ArrayList();
        String query = String.format("select * from role");
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    role = new Role(
                            resultSet.getLong(1),
                            resultSet.getString(2)
                    );
                    list.add(role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Set<Role> getAllRolesByUserId(long userId) {
       return executor.execQuery(String.format(
                        "SELECT * FROM role WHERE id IN (SELECT role_id FROM user_role WHERE user_id IN (SELECT id FROM user WHERE id = '%s'))",
                        userId),
                        result_role -> {
                            Set<Role> roles = new HashSet<>();
                            System.out.println("Size = " + roles.size());
                            while(result_role.next()){
                                roles.add(
                                        new Role(
                                                result_role.getLong(1),
                                                result_role.getString(2)
                                        )
                                );
                            }
                            return roles;
                        });
    }

}
