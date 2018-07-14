package com.example.nguyentin.catchyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignUp2Activity extends AppCompatActivity {

    private LinearLayout btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        ImageView imageViewChangeComponent = findViewById(R.id.imageViewChangeComponent);
        imageViewChangeComponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp2Activity.this, SignUpActivity.class));
            }
        });

        TextView textViewComback = findViewById(R.id.textViewComback);
        textViewComback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp2Activity.this, SignUpActivity.class));
            }
        });

        Button btn_continute = findViewById(R.id.btn_continute);
        btn_continute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp2Activity.this, LoginActivity.class));
            }
        });

    }
}
