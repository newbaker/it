package com.itheima.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;//商品编号
    private String pname;//商品名称
    private double price;//价格
    private String category;//类别名称
    private String desc;//描述

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Product(){}
    public Product(int id, String pname, double price, String category, String desc) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.category = category;
        this.desc = desc;
    }
}
