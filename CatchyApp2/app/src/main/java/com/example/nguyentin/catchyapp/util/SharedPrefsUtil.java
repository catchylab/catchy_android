package com.example.nguyentin.catchyapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nguyentin.catchyapp.CatchyApplication;

import java.util.Locale;

/**
 * Create by DavidSon Nguyen
 */

public class SharedPrefsUtil {
    // Constructor
    private static final String SHARED_PREF_NAME = "shared pref name";
    private static SharedPreferences mAppSharedPrefs;
    private static SharedPreferences.Editor mPrefsEditor;
    private static SharedPrefsUtil instance;

    public SharedPrefsUtil() {
        this.mAppSharedPrefs = CatchyApplication.getInstance().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        this.mPrefsEditor = mAppSharedPrefs.edit();
    }

    public static SharedPrefsUtil getInstance(){
        if (instance == null){
            instance = new SharedPrefsUtil();
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

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> anonymousClass) {
        if (anonymousClass == String.class) {
            return (T) mAppSharedPrefs.getString(key, "");
        } else if (anonymousClass == Boolean.class) {
            return (T) Boolean.valueOf(mAppSharedPrefs.getBoolean(key, false));
        } else if (anonymousClass == Float.class) {
            return (T) Float.valueOf(mAppSharedPrefs.getFloat(key, 0));
        } else if (anonymousClass == Integer.class) {
            return (T) Integer.valueOf(mAppSharedPrefs.getInt(key, 0));
        } else if (anonymousClass == Long.class) {
            return (T) Long.valueOf(mAppSharedPrefs.getLong(key, 0));
        }  else {
            return (T) GsonUtil.getInstance().fromJson(mAppSharedPrefs.getString(key, ""), anonymousClass);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> anonymousClass, T defaultValue) {
        if (anonymousClass == String.class) {
            return (T) mAppSharedPrefs.getString(key, (String) defaultValue);
        } else if (anonymousClass == Boolean.class) {
            return (T) Boolean.valueOf(mAppSharedPrefs.getBoolean(key, (Boolean) defaultValue));
        } else if (anonymousClass == Float.class) {
            return (T) Float.valueOf(mAppSharedPrefs.getFloat(key, (Float) defaultValue));
        } else if (anonymousClass == Integer.class) {
            return (T) Integer.valueOf(mAppSharedPrefs.getInt(key, (Integer) defaultValue));
        } else if (anonymousClass == Long.class) {
            return (T) Long.valueOf(mAppSharedPrefs.getLong(key, (Long) defaultValue));
        } else {
            return GsonUtil.getInstance().fromJson(mAppSharedPrefs.getString(key, ""), anonymousClass);
        }
    }

    public <T> void put(String key, T data) {
        SharedPreferences.Editor editor = mAppSharedPrefs.edit();
        editor.remove(key).apply();
        if (data instanceof String) {
            editor.putString(key, (String) data);
        } else if (data instanceof Boolean) {
            editor.putBoolean(key, (Boolean) data);
        } else if (data instanceof Float) {
            editor.putFloat(key, (Float) data);
        } else if (data instanceof Integer) {
            editor.putInt(key, (Integer) data);
        } else if (data instanceof Long) {
            editor.putLong(key, (Long) data);
        } else {
            editor.putString(key, GsonUtil.getInstance().toJson(data));
        }
        editor.apply();
    }

    public void clear() {
        mAppSharedPrefs.edit().clear().apply();
    }
}
