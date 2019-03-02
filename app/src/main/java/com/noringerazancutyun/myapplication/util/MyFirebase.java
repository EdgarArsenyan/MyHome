package com.noringerazancutyun.myapplication.util;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.noringerazancutyun.myapplication.activity.EmailPasswordActivity;
import com.noringerazancutyun.myapplication.activity.RegisterActivity;

public class MyFirebase {

public FirebaseAuth mAuth= FirebaseAuth.getInstance();
 public FirebaseAuth.AuthStateListener listener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {


        }
    };

}
