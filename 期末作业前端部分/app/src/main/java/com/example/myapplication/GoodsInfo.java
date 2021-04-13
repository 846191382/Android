package com.example.myapplication;

import java.util.ArrayList;


public class GoodsInfo {
    public long rowid; // 行号
    public int xuhao; // 序号
    public String name; // 名称
    public String desc; // 描述
    public String price; // 价格
    public String thumb_path; // 小图的保存路径
    public String pic_path; // 大图的保存路径
    public int thumb; // 小图的资源编号
    public int pic; // 大图的资源编号

    public GoodsInfo() {
        rowid = 0L;
        xuhao = 0;
        name = "";
        desc = "";
        price = "";
        thumb_path = "";
        pic_path = "";
        thumb = 0;
        pic = 0;
    }

    // 声明一个手机商品的名称数组
    private static String[] mNameArray = {
            "荷塘月色", "情缘", "夏天", "凉风", "土里土气容马屁", "爸爸"
    };
    // 声明一个手机商品的描述数组
    private static String[] mDescArray = {
            "你好，在干嘛",
            "吃了吗",
            "在哪里呀",
            "今天天气不错",
            "出门记得打伞",
            "hi"
    };
    // 声明一个手机商品的价格数组
    private static String[] mPriceArray = {"6888", "3999", "2999", "2899", "2698", "2098"};
    // 声明一个手机商品的小图数组
    private static int[] mThumbArray = {
            R.drawable.iphone_s, R.drawable.huawei_s, R.drawable.xiaomi_s,
            R.drawable.oppo_s, R.drawable.vivo_s, R.drawable.meizu_s
    };
    // 声明一个手机商品的大图数组
    private static int[] mPicArray = {
            R.drawable.meinu1, R.drawable.meinu1, R.drawable.meinu1,
            R.drawable.meinu1, R.drawable.meinu1, R.drawable.meinu1
    };

    // 获取默认的手机信息列表
    public static ArrayList<GoodsInfo> getDefaultList() {
        ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
        for (int i = 0; i < mNameArray.length; i++) {
            GoodsInfo info = new GoodsInfo();
            info.name = mNameArray[i];
            info.desc = mDescArray[i];
            info.price = mPriceArray[i];
            info.thumb = mThumbArray[i];
            info.pic = mPicArray[i];
            goodsList.add(info);
        }
        return goodsList;
    }

}
