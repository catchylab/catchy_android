package com.example.nguyentin.catchyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    private LinearLayout btn_back;
    private Button btn_continute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageView imageViewChangeComponent = findViewById(R.id.imageViewChangeComponent);
        imageViewChangeComponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, NavSignInOrSignUpActivity.class));
            }
        });

        TextView textViewComback = findViewById(R.id.textViewComback);
        textViewComback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, NavSignInOrSignUpActivity.class));
            }
        });

        btn_continute = findViewById(R.id.btn_continute);
        btn_continute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignUp2Activity.class));
            }
        });


    }
}
