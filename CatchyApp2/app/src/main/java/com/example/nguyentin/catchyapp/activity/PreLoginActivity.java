package com.example.nguyentin.catchyapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.CatchyApplication;
import com.example.nguyentin.catchyapp.Constant.Constant;
import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.util.ActivityUtil;
import com.example.nguyentin.catchyapp.util.AppSharedPrefs;

/**
 * Create by DavidSon Nguyen
 */

public class PreLoginActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    TextView txtFacebook, txtSignUp;
    LinearLayout linearSignIn;
    RadioButton rdbVn, rdbEn;
    View lineVN, lineEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_login);
        initView();
        rdbVn.setOnCheckedChangeListener(this);
        rdbEn.setOnCheckedChangeListener(this);

        txtFacebook.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);
        linearSignIn.setOnClickListener(this);

        if (AppSharedPrefs.getInstance().getLanguage().equals("vi")){
            rdbVn.setChecked(true);
        }else {
            rdbEn.setChecked(true);
        }
    }

    private void initView() {
        txtFacebook = (TextView) findViewById(R.id.txtFacebook);
        txtSignUp = (TextView) findViewById(R.id.txtSignUp);

        linearSignIn = (LinearLayout) findViewById(R.id.linearSignIn);

        rdbVn = (RadioButton) findViewById(R.id.rdbVN);
        rdbEn = (RadioButton) findViewById(R.id.rdbEN);

        lineVN = (View) findViewById(R.id.lineVN);
        lineEN = (View) findViewById(R.id.lineEN);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.rdbVN:
                if (b){
                    lineVN.setBackground(getDrawable(R.drawable.line_language_checked));
                    rdbEn.setChecked(false);
                }else {
                    lineVN.setBackground(getDrawable(R.drawable.line_language_normal));
                }
                break;
            case R.id.rdbEN:
                if (b){
                    lineEN.setBackground(getDrawable(R.drawable.line_language_checked));
                    rdbVn.setChecked(false);
                }else {
                    lineEN.setBackground(getDrawable(R.drawable.line_language_normal));
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtFacebook:
                break;
            case R.id.txtSignUp:
                ActivityUtil.launchActivity(this, SignUpActivity.class);
                break;
            case R.id.linearSignIn:
                if (rdbVn.isChecked()){
                    AppSharedPrefs.getInstance().setLanguage(Constant.LANG_VIETNAM);
                    CatchyApplication.setLanguageConfig(Constant.LANG_VIETNAM);
                }

                if (rdbEn.isChecked()){
                    AppSharedPrefs.getInstance().setLanguage(Constant.LANG_ENGLISH);
                    CatchyApplication.setLanguageConfig(Constant.LANG_ENGLISH);
                }
                ActivityUtil.launchActivity(this, LoginActivity.class);
                break;
        }
    }
}
