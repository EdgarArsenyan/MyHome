package com.noringerazancutyun.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.noringerazancutyun.myapplication.R;
import com.noringerazancutyun.myapplication.activ.AddActivity;
import com.noringerazancutyun.myapplication.activ.EmailPasswordActivity;
import com.noringerazancutyun.myapplication.activ.HomeActivity;
import com.noringerazancutyun.myapplication.activ.RegisterActivity;


public class UserMainHomeFragment extends Fragment {

    FloatingActionButton mAddStatement;
    TextView mProfile, mNotification, mHistory, mStatement, mLogout;
    FirebaseAuth authForMainHome;

    public UserMainHomeFragment() {
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_main_home, container, false);

        mAddStatement = view.findViewById(R.id.floatingButton_statement);
        mProfile = view.findViewById(R.id.profile_txt);
        mNotification = view.findViewById(R.id.notification_txt);
        mHistory = view.findViewById(R.id.history_txt);
        mStatement = view.findViewById(R.id.statement_txt);
        mLogout = view.findViewById(R.id.logout_txt);

        mAddStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });

clickLogoutAction();
        return view;
    }


    public void clicProfileAction(){
        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickNotificAction(){
        mNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickhistoryAction(){
        mHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickStatementAction(){
        mHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickLogoutAction(){
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomeActivity.class);
                startActivity(intent);
                    authForMainHome.signOut();

            }
        });
    }

}
