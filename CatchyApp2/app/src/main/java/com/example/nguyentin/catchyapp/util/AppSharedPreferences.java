package com.example.nguyentin.catchyapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Locale;

public class AppSharedPreferences {
    // Constructor
    private SharedPreferences mAppSharedPrefs;
    private SharedPreferences.Editor mPrefsEditor;

    public AppSharedPreferences(Context context) {
        this.mAppSharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.mPrefsEditor = mAppSharedPrefs.edit();
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
