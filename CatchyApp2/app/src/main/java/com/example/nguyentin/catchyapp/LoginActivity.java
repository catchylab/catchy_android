package com.example.nguyentin.catchyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.activity.PreLoginActivity;
import com.example.nguyentin.catchyapp.startup.HomeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtSignIn;
    EditText edtEmail, edtPass;
    ImageView imgShowPass, imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        imgShowPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        edtPass.setInputType(InputType.TYPE_NULL);
                        edtPass.setTransformationMethod(new SingleLineTransformationMethod());
                        break;
                    case MotionEvent.ACTION_UP:
                        edtPass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        edtPass.setTransformationMethod(new PasswordTransformationMethod());
                        edtPass.setSelection(edtPass.getText().length());
                        break;
                }
                return true;
            }
        });

        imgBack.setOnClickListener(this);
        txtSignIn.setOnClickListener(this);
    }

    private void initView(){
        txtSignIn = (TextView) findViewById(R.id.txtLogIn);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPass  = (EditText) findViewById(R.id.edtPass);

        imgShowPass = (ImageView) findViewById(R.id.imgShowPass);
        imgBack     = (ImageView) findViewById(R.id.imgBack);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
                goBack();
                break;
            case R.id.txtLogIn:
                // check login
                gotoHome();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        goBack();
    }

    private void gotoHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void goBack(){
        Intent intent = new Intent(this, PreLoginActivity.class);
        startActivity(intent);
    }
}
