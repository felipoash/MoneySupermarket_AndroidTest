package com.test.androidtest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.test.androidtest.R;
import com.test.androidtest.adapter.FruitAdapter;
import com.test.androidtest.api.FruitService;
import com.test.androidtest.api.RestApiManager;
import com.test.androidtest.model.Fruit;
import com.test.androidtest.model.Fruits;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mFruitRecyclerView;
    private Toolbar mToolbar;
    private FruitAdapter mFruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();

        mFruitAdapter = new FruitAdapter();
        mFruitRecyclerView.setAdapter(mFruitAdapter);


        FruitService service = new RestApiManager().getFruitService();

        Observable<Fruits> observable = service.getFruits();

        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Fruits>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError " + e.getMessage());
                    }

                    @Override
                    public void onNext(Fruits fruits) {

                        Log.d(TAG, "onNext " + fruits.getFruits());

                        for (Fruit fruit : fruits.getFruits()) {
                            mFruitAdapter.addFruit(fruit);
                        }
                    }
                });
    }

    private void configViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        mToolbar.setTitle("Android Test");
        setSupportActionBar(mToolbar);

        mFruitRecyclerView = (RecyclerView) findViewById(R.id.fruit_recycler_view);

        mFruitRecyclerView.setHasFixedSize(true);
        mFruitRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mFruitRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mFruitRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
