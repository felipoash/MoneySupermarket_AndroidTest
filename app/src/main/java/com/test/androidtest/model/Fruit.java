package com.test.androidtest.model;

import com.google.gson.annotations.Expose;

/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public class Fruit {

    @Expose
    private String name;

    @Expose
    private String price;

    @Expose
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
