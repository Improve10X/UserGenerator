package com.improve10x.usergenerator.randomNetwork;

import com.improve10x.usergenerator.Constants;
import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomPersonApiService {

    @GET(Constants.GET_RANDOM_END_POINT)
    Call<List<User>> getRandomPeople();
}
