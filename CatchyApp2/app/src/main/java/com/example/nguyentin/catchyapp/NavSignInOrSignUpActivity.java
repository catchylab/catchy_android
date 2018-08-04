package com.example.nguyentin.catchyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.activity.SignUpActivity;

public class NavSignInOrSignUpActivity extends AppCompatActivity {

    private Button btn_register_email;
    private TextView btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_sign_in_or_sign_up);

        btn_register_email = (Button) findViewById(R.id.btn_register_email);
        btn_register_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavSignInOrSignUpActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btn_login = (TextView) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavSignInOrSignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
