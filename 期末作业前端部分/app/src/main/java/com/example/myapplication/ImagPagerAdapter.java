package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class ImagPagerAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<ImageView>mViewList=new ArrayList<ImageView>();
    private ArrayList<PersonInfo>mGoodsList=new ArrayList<PersonInfo>();
    public ImagPagerAdapter(Context context,ArrayList<PersonInfo>goodsList){
        mContext=context;
        mGoodsList=goodsList;

    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view,Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
