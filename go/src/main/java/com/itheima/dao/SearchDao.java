package com.itheima.dao;

import com.itheima.model.Product;
import com.itheima.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    //查找所有商品
    public List<Product> findAll() throws SQLException {
        try {
            String sql = "SELECT * FROM products;";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据条件查找商品
    public List<Product> search(String pname, String minPrice, String maxPrice, String category) throws SQLException {

        //创建一个可变字符串,用于拼接sql语句
        StringBuilder sql = new StringBuilder("SELECT * FROM products where 1=1 ");
        //创建一个参数集合
        ArrayList<Object> list = new ArrayList<>();
        //判断
        if (pname != null && !pname.trim().equals("")) {
            sql.append("AND pname LIKE ?");
            list.add("%" + pname.trim() + "%");
        }
        if (minPrice != null && !minPrice.trim().equals("")) {
            sql.append("AND ? <= price ");
            list.add(minPrice.trim());
        }
        if (maxPrice != null && !maxPrice.trim().equals("")) {
            sql.append("AND ? >= price");
            list.add(maxPrice.trim());
        }
        if (category != null && !category.trim().equals("")) {
            sql.append("AND category LIKE ?");
            list.add("%" + category.trim() + "%");
        }
        Object[] array = list.toArray();
        return jdbcTemplate.query(sql.toString(), array, new BeanPropertyRowMapper<>(Product.class));
    }
}
