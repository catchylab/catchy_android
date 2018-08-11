package com.example.nguyentin.catchyapp.server;

/**
 * Create by DavidSon Nguyen
 */

public interface ApiCallback {
    void callback(String status, int resultCode, Object object);
}
