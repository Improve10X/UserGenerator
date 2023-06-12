package com.improve10x.usergenerator;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApi {
    public UserApiService createUserApiService() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://peoplegeneratorapi.live/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        UserApiService userApiService = retrofit.create(UserApiService.class);
        return userApiService;
    }
}
