package com.improve10x.usergenerator.network.randomNetwork;

import com.improve10x.usergenerator.Constants;
import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomPeopleApiService {

    @GET(Constants.PEOPLE_GENERATOR_END_POINT)
    Call<List<User>> getRandomPeople();
}
