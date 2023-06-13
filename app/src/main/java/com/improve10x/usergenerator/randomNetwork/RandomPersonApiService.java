package com.improve10x.usergenerator.randomNetwork;

import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomPersonApiService {

    @GET("api/person/10")
    Call<List<User>> getRandomPeople();
}
