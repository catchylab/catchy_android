package com.example.nguyentin.catchyapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.util.SharedPrefsUtil;

/**
 * Create by DavidSon Nguyen
 */

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (SharedPrefsUtil.getInstance().getFirstLaunch()){
            // first launch
            SharedPrefsUtil.getInstance().setFirstLaunch();
            gotoIntroActivity();
        }else {
            // second launch
            if (SharedPrefsUtil.getInstance().getUserToken().equals("")){
                // not sign in
                gotoNextActivity();
            }else {
                gotoHomeActivity();
            }
        }
    }

    public void gotoHomeActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void gotoIntroActivity(){
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
        finish();
    }

    public void gotoNextActivity(){
        // temp
        Intent intent = new Intent(this, PreLoginActivity.class);
        startActivity(intent);
        finish();
    }
}
