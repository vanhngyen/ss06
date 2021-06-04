package com.example.ss06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdater.IOnClickItem {

   List<Product> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //b1:data
        initData();
        //b2:adapter
        ProductAdater adater = new ProductAdater(this,listProduct,this);
        //b3:layoutManager
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);

        //b4:RecyclerView
        RecyclerView rvProduct = (RecyclerView) findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adater);
    }

    private void initData() {
        listProduct.add(new Product("Zara P1","Love Shift1", "1100.000",R.drawable.p1));
        listProduct.add(new Product("Zara P2","Love Shift2", "1200.000",R.drawable.p2));
        listProduct.add(new Product("Zara P3","Love Shift3", "1300.000",R.drawable.p3));
        listProduct.add(new Product("Zara P4","Love Shift4", "1400.000",R.drawable.p4));
        listProduct.add(new Product("Zara P5","Love Shift5", "1500.000",R.drawable.p5));


    }
    //Handle when click item RecycleView
    @Override
    public void onClickItem(int position) {
        Product product = listProduct.get(position);
        Toast.makeText(this,product.getTitle(),Toast.LENGTH_SHORT).show();
    }
}
