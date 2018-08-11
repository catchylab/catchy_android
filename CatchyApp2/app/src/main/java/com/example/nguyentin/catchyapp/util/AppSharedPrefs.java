package com.example.nguyentin.catchyapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nguyentin.catchyapp.CatchyApplication;

import java.util.Locale;

/**
 * Create by DavidSon Nguyen
 */

public class AppSharedPrefs {
    // Constructor
    private static final String SHARED_PREF_NAME = "shared pref name";
    private static SharedPreferences mAppSharedPrefs;
    private static SharedPreferences.Editor mPrefsEditor;
    private static AppSharedPrefs instance;

    public AppSharedPrefs() {
        this.mAppSharedPrefs = CatchyApplication.getInstance().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        this.mPrefsEditor = mAppSharedPrefs.edit();
    }

    public static AppSharedPrefs getInstance(){
        if (instance == null){
            instance = new AppSharedPrefs();
        }
        return instance;
    }

    public void setFirstLaunch(){
        mPrefsEditor.putBoolean("first launch", false);
        mPrefsEditor.commit();
    }

    public boolean getFirstLaunch(){
        return mAppSharedPrefs.getBoolean("first launch", true);
    }

    public void setFirstLogin(){
        mPrefsEditor.putBoolean("first login", false);
        mPrefsEditor.commit();
    }

    public boolean getFirstLogin(){
        return mAppSharedPrefs.getBoolean("first login", true);
    }

    public void setUserToken(String token){
        mPrefsEditor.putString("user token", token);
        mPrefsEditor.commit();
    }

    public String getUserToken(){
        return mAppSharedPrefs.getString("user token", "");
    }

    public void setLanguage(String lang){
        mPrefsEditor.putString("language", lang);
        mPrefsEditor.commit();
    }

    public String getLanguage(){
        return mAppSharedPrefs.getString("language", getDefaultLanguageCode());
    }

    private String getDefaultLanguageCode() {
        final Locale locale = Locale.getDefault();
        final StringBuilder language = new StringBuilder(locale.getLanguage());
        return language.toString();
    }
}
