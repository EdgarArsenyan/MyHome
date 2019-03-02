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

import com.noringerazancutyun.myapplication.R;
import com.noringerazancutyun.myapplication.activity.AddActivity;
import com.noringerazancutyun.myapplication.activity.HomeActivity;
import com.noringerazancutyun.myapplication.activity.UserInfoActivity;
import com.noringerazancutyun.myapplication.models.UserInform;
import com.noringerazancutyun.myapplication.util.MyFirebase;


public class UserMainHomeFragment extends Fragment {

    FloatingActionButton mAddStatement;
    TextView mProfile, mNotification, mHistory, mStatement, mLogout, mUserName;
    MyFirebase firebase = new MyFirebase();
    UserInform user = new UserInform();

    public UserMainHomeFragment() {
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_main_home, container, false);

        mAddStatement = view.findViewById(R.id.add_statement_button);
        mProfile = view.findViewById(R.id.profile_txt);
        mNotification = view.findViewById(R.id.notification_txt);
        mHistory = view.findViewById(R.id.history_txt);
        mStatement = view.findViewById(R.id.statement_txt);
        mLogout = view.findViewById(R.id.logout_txt);
        mUserName = view.findViewById(R.id.user_name_surmname_txt);

        mAddStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });
        textUser();
        clickLogoutAction();
        clickProfileAction();
        return view;
    }

    private void textUser() {
if (firebase.mAuth.getUid()!= null){
    mUserName.setText(user.mUserName + "  " + user.mUserSurname);

}else{
    mUserName.setText("User");
}

    }


    public void clickProfileAction(){
        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UserInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickNotificAction(){
        mNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UserInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickhistoryAction(){
        mHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UserInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickStatementAction(){
        mHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UserInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickLogoutAction(){
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomeActivity.class);
                firebase.mAuth.signOut();
                firebase.mAuth.addAuthStateListener(firebase.listener);
                startActivity(intent);
            }
        });
    }

}
