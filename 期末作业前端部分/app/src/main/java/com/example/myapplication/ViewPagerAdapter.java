package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mData;
    private LayoutInflater mInflater;
    private ArrayList<ImageView> mViewList=new ArrayList<ImageView>();
    private ArrayList<PersonInfo>mGoodsList=new ArrayList<PersonInfo>();

    private int[] colorArray = new int[]{android.R.color.black, android.R.color.holo_blue_dark, android.R.color.holo_green_dark, android.R.color.holo_red_dark};


    public ViewPagerAdapter(Context context, ArrayList<PersonInfo>goodsList) {
        mContext = context;
        mGoodsList=goodsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycleview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonInfo goodsInfo=mGoodsList.get(position);
        holder.imageView.setImageResource(goodsInfo.pic);
        holder.user.setText(goodsInfo.name);
        holder.age.setText(goodsInfo.price+"");
        holder.des.setText(goodsInfo.desc);
    }


    @Override
    public int getItemCount() {
        return mGoodsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        View view;
        TextView user;
        TextView age;
        TextView des;
        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagView);
            view= itemView.findViewById(R.id.view);
            user=itemView.findViewById(R.id.usename);
            age=itemView.findViewById(R.id.age);
            des=itemView.findViewById(R.id.desc);
        }
    }
}

