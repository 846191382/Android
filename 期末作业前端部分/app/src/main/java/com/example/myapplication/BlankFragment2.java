package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment {
    private EditText username;
    private EditText password;
    private EditText email;
    private Button zhuce;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    OkHttpClient client=new OkHttpClient();
    public BlankFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment2 newInstance(String param1, String param2) {
        BlankFragment2 fragment = new BlankFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Context mContext = getActivity();
        username= view.findViewById(R.id.username);
        email=view.findViewById(R.id.email);
        password=view.findViewById(R.id.password);
        zhuce=view.findViewById(R.id.register);
        zhuce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String email = password.getText().toString().trim();
                Log.i("TAG", name);
                Log.i("TAG", pass);
                MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
                RequestBody body2 = new FormBody.Builder()
                        .add("email", email)
                        .add("name", name)
                        .add("pass", pass)
                        .build();
                Request request = new Request.Builder()
                        .url("http://172.18.45.44:3030/newList")
                        .post(body2)
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {

                    @Override
                    public void onResponse(Call arg0, Response arg1) throws IOException {
                        Log.v("TAG", "onResponse()");
                    }

                    @Override
                    public void onFailure(Call arg0, IOException arg1) {
                        Log.v("TAG", "onFailure()");
                    }
                });
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank3, container, false);
        return view;
    }
}