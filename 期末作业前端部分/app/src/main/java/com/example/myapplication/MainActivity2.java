package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
ImageView img;
    String usename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        usename=intent.getStringExtra("username");
        Bitmap qrCode = ZxingUtils.createQRCode(usename);
        img=findViewById(R.id.img);
        img.setImageBitmap(qrCode);
    }
}