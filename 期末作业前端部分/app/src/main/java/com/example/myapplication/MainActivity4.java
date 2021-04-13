package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    ViewPager2 mviewPager2;
    Button jump;
    TextView my;
    String usename;
    TextView message;
    ArrayList<PersonInfo> goodsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ArrayList<PersonInfo> goodsList= PersonInfo.getDefaultList();
        ViewPagerAdapter adapter=new ViewPagerAdapter(this,goodsList);
        mviewPager2 = findViewById(R.id.vp);
        mviewPager2.setAdapter(adapter);
        Intent intent=getIntent();
       usename=intent.getStringExtra("username");
       message=findViewById(R.id.mess);
        jump=findViewById(R.id.jump);
        my=findViewById(R.id.my);
        jump.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity4.this, map.class);
                startActivity(intent1);
            }});
        my.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, UsersActivity.class);
                intent.putExtra("username",usename);
                startActivity(intent);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, Message.class);
                startActivity(intent);
            }
        });
    }
}