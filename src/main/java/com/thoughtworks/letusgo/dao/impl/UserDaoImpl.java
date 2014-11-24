package com.thoughtworks.letusgo.dao.impl;

import com.thoughtworks.letusgo.dao.UserDao;
import com.thoughtworks.letusgo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getUserByName(String name) {
        String sql = "select * from users where name = :name";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("name", name);
        return namedParameterJdbcTemplate.query(sql, namedParameters, new UserMapper()).get(0);
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into users values(:id, :name, :password, :rank)";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("id", null);
        namedParameters.put("name", user.getName());
        namedParameters.put("password", user.getPassword());
        namedParameters.put("rank", user.getRank());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    private static final class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getInt("rank")
            );
            return user;
        }
    }
}
