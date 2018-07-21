package com.example.nguyentin.catchyapp.server;

public interface ApiCallback {
    void callback(String status, int resultCode, Object object);
}
