package com.noringerazancutyun.myapplication.activ;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.noringerazancutyun.myapplication.R;

public class RegisterActivity extends AppCompatActivity {

Context context;
    EditText nameET;
    EditText surnameET;
    EditText emailET;
    EditText phoneET;

    private static final String TAG = "MainActivity";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText mEmail, mPassword;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEmail = findViewById(R.id.user_email);
        mPassword = (EditText) findViewById(R.id.user_password);
        saveBtn = findViewById(R.id.saveBtn);
//        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

    }




}
