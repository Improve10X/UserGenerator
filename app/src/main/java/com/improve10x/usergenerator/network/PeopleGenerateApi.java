package com.improve10x.usergenerator.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleGenerateApi {

    public PeopleGenerateApiService createUserApiService() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://peoplegeneratorapi.live/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        PeopleGenerateApiService peopleGenerateApiService = retrofit.create(PeopleGenerateApiService.class);
        return peopleGenerateApiService;
    }
}
