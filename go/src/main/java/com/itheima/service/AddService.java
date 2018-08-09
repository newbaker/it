package com.itheima.service;

import com.itheima.dao.AddDao;

public class AddService {

    private AddDao addDao = new AddDao();

    public boolean add(String pname, String price, String category, String desc) throws Exception {
        double parseDouble = Double.parseDouble(price);
        int i = addDao.add(pname, parseDouble, category, desc);
        return i > 0;
    }
}