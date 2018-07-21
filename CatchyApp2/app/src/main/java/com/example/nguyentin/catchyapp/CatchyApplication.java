package com.example.nguyentin.catchyapp;

import android.app.Application;

import com.example.nguyentin.catchyapp.server.CatchyApi;

public class CatchyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CatchyApi.initAPI();
    }
}
