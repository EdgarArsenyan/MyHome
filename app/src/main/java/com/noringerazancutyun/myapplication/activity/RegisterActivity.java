package com.noringerazancutyun.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.noringerazancutyun.myapplication.R;
import com.noringerazancutyun.myapplication.models.UserInform;

public class RegisterActivity extends BaseActivity {


    private FirebaseAuth mAuth;
    FirebaseUser user;



    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText mName, mSurname, mPhone;
    private ImageView mSaveButton;
    private DatabaseReference mDataBaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        mName = findViewById(R.id.user_name);
        mSurname = findViewById(R.id.user_surname);
        mPhone = findViewById(R.id.user_phone);
        mSaveButton = findViewById(R.id.create_img_register_activity);
        mAuth = FirebaseAuth.getInstance();
        mDataBaseReference = FirebaseDatabase.getInstance().getReference("User");

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToDataBase();

                Toast.makeText(RegisterActivity.this, "User createrd", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }



    private void writeToDataBase(){

        String name = mName.getText().toString().trim();
        String surname = mSurname.getText().toString();
        String phone = mPhone.getText().toString();
        String email = user.getEmail();

        UserInform userInfo = new UserInform(name, email, surname, phone);
        mDataBaseReference.child(user.getUid()).setValue(userInfo);

    }
}
