package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class particulars extends AppCompatActivity {
     int position;
     TextView title,name;
     ImageView icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);
        ArrayList<GoodsInfo> mGoodsList= GoodsInfo.getDefaultList();
        Bundle bundle=getIntent().getExtras();
        position=bundle.getInt("position");
        GoodsInfo goodsInfo=mGoodsList.get(position);
        String title1=goodsInfo.name;
        String name1=goodsInfo.desc;
        String price1=goodsInfo.price;

        title=(TextView)findViewById(R.id.title);
        name=(TextView)findViewById(R.id.name);
        icon=(ImageView)findViewById(R.id.icon) ;
        icon.setImageResource(goodsInfo.pic);
        title.setText(title1);
        name.setText(name1);
    }
}