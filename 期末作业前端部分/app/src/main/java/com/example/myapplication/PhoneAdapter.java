package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhoneAdapter extends BaseAdapter implements
        AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
    private Context mContext; // 声明一个上下文对象
    private ArrayList<GoodsInfo> mGoodsList; // 声明一个行星信息队列

    // 行星适配器的构造函数，传入上下文与行星队列
    public PhoneAdapter(Context context, ArrayList<GoodsInfo> phone_list) {
        mContext = context;
        mGoodsList = phone_list;
    }
    @Override
    public int getCount() {
        return mGoodsList.size();
    }

    @Override
    public Object getItem(int arg0) {
        return mGoodsList.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) { // 转换视图为空
            holder = new ViewHolder(); // 创建一个新的视图持有者
            // 根据布局文件item_list.xml生成转换视图对象
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list, null);
            holder.icon = convertView.findViewById(R.id.icon);
            holder.title=convertView.findViewById(R.id.title);
            holder.name = convertView.findViewById(R.id.name);

            // 将视图持有者保存到转换视图当中
            convertView.setTag(holder);
        } else { // 转换视图非空
            // 从转换视图中获取之前保存的视图持有者
            holder = (ViewHolder) convertView.getTag();
        }
        GoodsInfo GoodsList= mGoodsList.get(position);
        holder.icon.setImageResource(GoodsList.pic); // 显示行星的图片
        holder.name.setText(GoodsList.desc); // 显示行星的名称
        holder.title.setText(GoodsList.name);
        return convertView;
    }



    public final class ViewHolder {
        public ImageView icon; // 声明行星图片的图像视图对象
        public TextView name; // 声明行星名称的文本视图对象
        public TextView title;

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(view.getContext(),particulars.class);
        Bundle bundle=new Bundle();
        bundle.putInt("position",position);
        intent.putExtras(bundle);
        view.getContext().startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(view.getContext(),particulars.class);
        Bundle bundle=new Bundle();
        bundle.putInt("position",position);
        intent.putExtras(bundle);
        view.getContext().startActivity(intent);
        return true;
    }
}




