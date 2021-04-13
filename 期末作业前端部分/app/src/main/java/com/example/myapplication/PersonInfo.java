package com.example.myapplication;

import java.util.ArrayList;


public class PersonInfo {
    public long rowid; // 行号
    public int xuhao; // 序号
    public String name; // 名称
    public String desc; // 描述
    public int price; // 价格
    public String thumb_path; // 小图的保存路径
    public String pic_path; // 大图的保存路径
    public int thumb; // 小图的资源编号
    public int pic; // 大图的资源编号

    public PersonInfo() {
        rowid = 0L;
        xuhao = 0;
        name = "";
        desc = "";
        price = 0;
        thumb_path = "";
        pic_path = "";
        thumb = 0;
        pic = 0;
    }

    // 声明一个手机商品的名称数组
    private static String[] mNameArray = {
            "Ven", "康康康", "梦想家", "周末同学", "豪豪", "马屁君"
    };
    // 声明一个手机商品的描述数组
    private static String[] mDescArray = {
            "沉默是毁谤最好的答覆",
            "往前走，凭着信心，而不是眼睛",
            "结局只要是我和你在一起，过程让我怎么痛都行",
            "我喜欢你的性格，但不喜欢你的性别",
            "沉默是毁谤最好的答覆",
            "往前走，凭着信心，而不是眼睛"
    };
    // 声明一个手机商品的价格数组
    private static int[] mPriceArray = {68, 39, 29, 28, 26, 20};
    // 声明一个手机商品的大图数组
    private static int[] mPicArray = {
            R.drawable.meinu1, R.drawable.meinu1, R.drawable.meinu1,
            R.drawable.meinu1, R.drawable.meinu1, R.drawable.meinu1
    };

    // 获取默认的手机信息列表
    public static ArrayList<PersonInfo> getDefaultList() {
        ArrayList<PersonInfo> goodsList = new ArrayList<PersonInfo>();
        for (int i = 0; i < mNameArray.length; i++) {
            PersonInfo info = new PersonInfo();
            info.name = mNameArray[i];
            info.desc = mDescArray[i];
            info.price = mPriceArray[i];
            info.pic = mPicArray[i];
            goodsList.add(info);
        }
        return goodsList;
    }

}
