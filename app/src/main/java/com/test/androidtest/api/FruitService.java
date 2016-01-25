package com.test.androidtest.api;

import com.test.androidtest.model.Fruits;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public interface FruitService {

    @GET("fruit")
    Observable<Fruits> getFruits();
}
