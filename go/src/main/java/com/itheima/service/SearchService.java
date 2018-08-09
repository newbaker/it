package com.itheima.service;

import com.itheima.dao.SearchDao;
import com.itheima.model.Product;

import java.util.List;

public class SearchService {
    private SearchDao searchDao = new SearchDao();

    //查找所有商品
    public List<Product> findAll() throws Exception {
        List<Product> products = searchDao.findAll();
        return products;
    }

    //根据条件查找商品
    public List<Product> sreach(String pname, String minPrice, String maxPrice, String category) throws Exception {
        List<Product> products = searchDao.search(pname, minPrice, maxPrice, category);
        return products;
    }
}
