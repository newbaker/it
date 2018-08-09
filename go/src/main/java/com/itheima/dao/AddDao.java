package com.itheima.dao;

import com.itheima.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class AddDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    public int add(String pname, Double price, String category, String desc) throws SQLException {

        try {
            String sql = "INSERT INTO products VALUES (NULL,?,?,?,?)";
            return jdbcTemplate.update(sql, pname, price, category, desc);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
