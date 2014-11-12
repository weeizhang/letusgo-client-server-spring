package com.thoughtworks.letusgo.dao.impl;

import com.thoughtworks.letusgo.dao.CategoryDao;
import com.thoughtworks.letusgo.entity.Category;
import com.thoughtworks.letusgo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Category> getCategories() {
        String sql = "select * from categories";
        return namedParameterJdbcTemplate.query(sql, new CategoryMapper());
    }

    @Override
    public Category getCategoryById(int id) {
        String sql = "select * from categories where id = :id";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("id", id);

        return namedParameterJdbcTemplate.query(sql, namedParameters, new CategoryMapper()).get(0);
    }

    @Override
    public void deleteCategoryById(int id) {
        String sql = "delete from categories where id = :id";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("id", id);
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    private static final class CategoryMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category(
                    rs.getInt("id"),
                    rs.getString("name")
            );
            return category;
        }
    }
}
