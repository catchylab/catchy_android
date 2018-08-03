package com.example.nguyentin.catchyapp;

import android.app.Application;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.nguyentin.catchyapp.server.CatchyApi;
import com.example.nguyentin.catchyapp.util.AppSharedPreferences;
import com.example.nguyentin.catchyapp.util.OperateBitmap;

import java.util.Locale;

import okhttp3.RequestBody;

public class CatchyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppSharedPreferences appSharedPreferences = new AppSharedPreferences(this);
        CatchyApi.initAPI();
        changeLanguageConfig(appSharedPreferences.getLanguage());
    }

    private void changeLanguageConfig(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}
