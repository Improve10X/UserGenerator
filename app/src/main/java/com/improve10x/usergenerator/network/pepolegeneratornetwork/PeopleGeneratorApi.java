package com.improve10x.usergenerator.network.pepolegeneratornetwork;

import com.improve10x.usergenerator.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleGeneratorApi {

    public PeopleGeneratorApiService createPeopleGeneratorApiService() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.RANDOM_PEOPLE_GENERATOR_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        PeopleGeneratorApiService peopleGeneratorApiService = retrofit.create(PeopleGeneratorApiService.class);
        return peopleGeneratorApiService;
    }
}
