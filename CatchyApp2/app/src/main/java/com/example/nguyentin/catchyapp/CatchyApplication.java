package com.example.nguyentin.catchyapp;

import android.app.Application;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.nguyentin.catchyapp.server.CatchyApi;
import com.example.nguyentin.catchyapp.util.OperateBitmap;

import okhttp3.RequestBody;

public class CatchyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CatchyApi.initAPI();
    }
}
