package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager vpager;
    private BlankFragment2 fragment1=new BlankFragment2();
    private BlankFragment3 fragment2=new BlankFragment3();
    private ArrayList fragList;
    private zhuce mAdapter;

    private TabLayout mTabLayout;

    private List<String> mTitleList = new ArrayList<String>();//页卡标题集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = (TabLayout)findViewById(R.id.tabs);

        fragList=new ArrayList();
        fragList.add(fragment1);
        fragList.add(fragment2);
        mTitleList.add("注册");
        mTitleList.add("登录");
        mTabLayout.addTab(mTabLayout.newTab().setText("选项卡一").setIcon(R.mipmap.ic_launcher));
        mTabLayout.addTab(mTabLayout.newTab().setText("选项卡二").setIcon(R.mipmap.ic_launcher));
        mAdapter=new zhuce(getSupportFragmentManager(),fragList)   ;
        vpager=findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(vpager);


    }
}