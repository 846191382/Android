package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import net.sf.json.JSONString;

import org.json.JSONException;
import org.json.JSONObject;

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
 * Use the {@link BlankFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment3 extends Fragment {
    final Context mContext = getActivity();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText username;
    private EditText password;
    private EditText email;
    private Button denglu;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    OkHttpClient client=new OkHttpClient();
    public BlankFragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment3 newInstance(String param1, String param2) {
        BlankFragment3 fragment = new BlankFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Context mContext = this.getActivity();
        username= view.findViewById(R.id.username);
        password=view.findViewById(R.id.password);
        denglu=view.findViewById(R.id.login);
        denglu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                Log.i("TAG", name);
                Log.i("TAG", pass);
                MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
                RequestBody body2 = new FormBody.Builder()
                        .add("name", name)
                        .add("pass", pass)
                        .build();
                Request request = new Request.Builder()
                        .url("http://172.18.45.44:3030/findList")
                        .post(body2)
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {

                    @Override
                    public void onResponse(Call arg0, Response arg1) throws IOException {
                        String body=arg1.body().string();
                        JSONObject object= null;
                        try {
                            object = new JSONObject(body);
                            String user=object.getJSONObject("obj").getJSONArray("list").getString(0);
                            JSONObject object1=new JSONObject(user);
                            String name=object1.getString("name");
                            if(name==null)
                            {
                                Toast toast=Toast.makeText(mContext, "登录失败", Toast.LENGTH_SHORT);
                                 //显示toast信息
                                toast.show();
                            }
                            else
                            {
                                Intent intent = new Intent(getActivity(), MainActivity4.class);
                                intent.putExtra("username",name);
                                startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call arg0, IOException arg1) {
                        Log.v("TAG", "onFailure()");
                        Toast.makeText(mContext, "登陆失败",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank4, container, false);
        return view;
    }
}