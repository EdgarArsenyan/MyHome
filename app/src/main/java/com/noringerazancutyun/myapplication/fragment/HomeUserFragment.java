package com.noringerazancutyun.myapplication.fragment;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.noringerazancutyun.myapplication.R;
import com.noringerazancutyun.myapplication.activ.EmailPasswordActivity;
import com.noringerazancutyun.myapplication.activ.RegisterActivity;


public class HomeUserFragment extends Fragment {

    ImageView loginImg, createImg;

    public HomeUserFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_user, container, false);

        loginImg = v.findViewById(R.id.login_img);
        createImg = v.findViewById(R.id.create_img);

        clickLogin();
        clickCreate();
        return v;
    }

    public void clickLogin(){
        loginImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EmailPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickCreate(){
        createImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
