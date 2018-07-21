package com.example.nguyentin.catchyapp.server;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;

public class CatchyApi {
    private static OkHttpClient okHttpClient = null;
    private static Retrofit.Builder retrofitBuilder = null;
    private static Retrofit retrofit = null;
    private static CatchyService catchyService = null;

    public static int recordsPage = 10;

    private static final int TIME_OUT = 60;
    private static final String BASE_URL = "";

    public static void initAPI(){
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();

        retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient);
        retrofit = retrofitBuilder.build();
        catchyService = retrofit.create(CatchyService.class);
    }
}
