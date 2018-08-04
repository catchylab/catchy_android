package com.example.nguyentin.catchyapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.startup.HomeActivity;
import com.example.nguyentin.catchyapp.util.AppSharedPreferences;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        AppSharedPreferences appSharedPreferences = new AppSharedPreferences(this);
        if (appSharedPreferences.getFirstLaunch()){
            // first launch
            appSharedPreferences.setFirstLaunch();
            gotoIntroActivity();
        }else {
            // second launch
            if (appSharedPreferences.getUserToken().equals("")){
                // not sign in
                gotoNextActivity();
            }else {
                gotoHomeActivity();
            }
        }
    }

    public void gotoHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
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
