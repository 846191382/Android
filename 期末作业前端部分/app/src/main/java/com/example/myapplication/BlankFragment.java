package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BlankFragment extends Fragment{
    private View mview;
    private LayoutInflater minflater;
    public BlankFragment(View view) {
        super();
        mview=view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(mview);
    }

    public View onCreateView(View view) {
        // Inflate the layout for this fragment
        return view;
    }
}