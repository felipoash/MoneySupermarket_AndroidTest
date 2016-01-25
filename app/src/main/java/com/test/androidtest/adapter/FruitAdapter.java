package com.test.androidtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.test.androidtest.R;
import com.test.androidtest.model.Fruit;
import com.test.androidtest.utilities.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.Holder> {

    private List<Fruit> mFruitList;

    public FruitAdapter() {
        mFruitList = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Fruit currentFruit = mFruitList.get(position);
        holder.mFruitName.setText(currentFruit.getName());
        holder.mFruitPrice.setText("£" + currentFruit.getPrice());

        Picasso.with(holder.itemView.getContext()).load("http://" + Constant.HOST + ":" + Constant.PORT + "/simple-fruit-api/api/image/" + currentFruit.getId()).placeholder(R.mipmap.ic_launcher).into(holder.mFruitImage);
    }

    public void addFruit(Fruit fruit) {
        mFruitList.add(fruit);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mFruitImage;
        private TextView mFruitName, mFruitPrice;

        public Holder(View itemView) {
            super(itemView);
            mFruitImage = (ImageView) itemView.findViewById(R.id.fruit_picture);
            mFruitName = (TextView) itemView.findViewById(R.id.fruit_name);
            mFruitPrice = (TextView) itemView.findViewById(R.id.fruit_price);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Fruit selectedFruit = mFruitList.get(getAdapterPosition());
            Toast.makeText(v.getContext(), "You clicked on " + selectedFruit.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
