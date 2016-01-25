package com.test.androidtest.model;

import com.google.gson.annotations.Expose;

/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public class Fruits {

    @Expose
    private Fruit[] fruit;

    public Fruit[] getFruits() {
        return fruit;
    }

    public void setFruits(Fruit[] fruits) {
        this.fruit = fruits;
    }
}
