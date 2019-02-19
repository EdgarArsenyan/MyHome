package com.noringerazancutyun.myapplication.activ;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.noringerazancutyun.myapplication.R;

public class EmailPasswordActivity extends AppCompatActivity {

    Button login, register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_password);
        register = findViewById(R.id.registerBtn);
        login = findViewById(R.id.loginBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmailPasswordActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmailPasswordActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
