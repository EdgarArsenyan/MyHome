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

        loginImg = v.findViewById(R.id.loginBtn);
        createImg = v.findViewById(R.id.create_img);
//        loginImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), EmailPasswordActivity.class);
//                HomeUserFragment.this.startActivity(intent);
//            }
//        });
//
//        loginImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), RelativeLayout.class);
//                HomeUserFragment.this.startActivity(intent);
//            }
//        });
//        clickLogin();
//        clickCreate();
        return v;
    }

//    public void clickLogin(){
//        loginImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), EmailPasswordActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    public void clickCreate(){
//        loginImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), RelativeLayout.class);
//                startActivity(intent);
//            }
//        });
//    }
}
