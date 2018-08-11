package com.example.nguyentin.catchyapp.util;

import com.google.gson.Gson;

/**
 * Create by DavidSon Nguyen
 */

public class GsonUtil {
    private static Gson instance;

    public static Gson getInstance(){
        if (instance == null){
            instance = new Gson();
        }
        return instance;
    }
}
