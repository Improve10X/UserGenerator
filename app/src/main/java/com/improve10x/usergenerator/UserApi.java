package com.improve10x.usergenerator;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApi {

    public UserApiService createUserApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://peoplegeneratorapi.live/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserApiService userApiService = retrofit.create(UserApiService.class);
        return userApiService ;
    }
}
