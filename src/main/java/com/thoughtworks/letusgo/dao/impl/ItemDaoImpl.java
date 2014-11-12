package com.thoughtworks.letusgo.dao.impl;

import com.thoughtworks.letusgo.dao.ItemDao;
import com.thoughtworks.letusgo.entity.Category;
import com.thoughtworks.letusgo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Item> getItems() {
        String sql = "select * from items,categories where items.category=categories.id";

        return namedParameterJdbcTemplate.query(sql, new ItemMapper());
    }

    private static final class ItemMapper implements RowMapper<Item> {
        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setBarcode(rs.getString("barcode"));
            item.setName(rs.getString("name"));
            item.setUnit(rs.getString("unit"));
            item.setPrice(rs.getDouble("price"));
            Category category = new Category(rs.getInt("category"),rs.getString("categories.name"));
            item.setCategory(category);
            return item;
        }
    }
}
