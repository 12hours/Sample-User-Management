package com.epam.test.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Dao implementation.
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAllUsers() {
        String getAllUsersSql = "select user_id, login, password, description from app_user";
        return jdbcTemplate.query(getAllUsersSql, new UserRowMapper());
    }

    @Override
    public User getUserById(Integer userId) {
        return null;
    }

    @Override
    public Integer addUser(User user) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

    }

    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("description"));
            return user;
        }
    }
}