package com.noringerazancutyun.myapplication.models;

import java.net.URL;

public class UserInform {

    private String mUserName, mUserEmail, mUserSurname, mUserPhoneNumber;

    private String userId;

    private String mImageUrl;



    public UserInform(String mUserName, String mUserEmail, String mUserSurname, String mUserPhoneNumber, String mImageUrl) {
        this.mUserName = mUserName;
        this.mUserEmail = mUserEmail;
        this.mUserSurname = mUserSurname;
        this.mUserPhoneNumber = mUserPhoneNumber;
        this.mImageUrl = mImageUrl;
    }

    public UserInform(){

    }

    public UserInform(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmUserEmail() {
        return mUserEmail;
    }

    public void setmUserEmail(String mUserEmail) {
        this.mUserEmail = mUserEmail;
    }

    public String getmUserSurname() {
        return mUserSurname;
    }

    public void setmUserSurname(String mUserSurname) {
        this.mUserSurname = mUserSurname;
    }

    public String getmUserPhoneNumber() {
        return mUserPhoneNumber;
    }

    public void setmUserPhoneNumber(String mUserPhoneNumber) {
        this.mUserPhoneNumber = mUserPhoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
