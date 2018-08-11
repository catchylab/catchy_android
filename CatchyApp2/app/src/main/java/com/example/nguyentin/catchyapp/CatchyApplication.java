package com.example.nguyentin.catchyapp;

import android.app.Application;
import android.content.res.Configuration;

import com.example.nguyentin.catchyapp.server.CatchyApi;
import com.example.nguyentin.catchyapp.util.SharedPrefsUtil;

import java.util.Locale;

/**
 * Create by DavidSon Nguyen
 */

public class CatchyApplication extends Application {
    private static CatchyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        CatchyApi.initAPI();
        setLanguageConfig(SharedPrefsUtil.getInstance().getLanguage());
    }

    public static CatchyApplication getInstance(){
        return instance;
    }

    public static void setLanguageConfig(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        instance.getBaseContext().getResources().updateConfiguration(config, instance.getBaseContext().getResources().getDisplayMetrics());
    }
}
