package com.example.myapplication;

public class Person {
    public long rowid;
    public int xuhao;
    public long goods_id;
    public int count;
    public String update_time;
    public PersonInfo goods;

    public Person() {
        rowid = 0L;
        xuhao = 0;
        goods_id = 0L;
        count = 0;
        update_time = "";
        goods = new PersonInfo();
    }
}
