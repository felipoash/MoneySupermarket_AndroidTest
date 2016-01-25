package com.test.androidtest.api;

import com.test.androidtest.utilities.Constant;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public class RestApiManager {

    private FruitService mFruitService;

    /**
     * This method is responsible for creating Fruit Service EndPoint
     *
     * @return FruitService
     */
    public FruitService getFruitService() {
        if (mFruitService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            mFruitService = retrofit.create(FruitService.class);
        }
        return mFruitService;
    }
}
