package com.improve10x.usergenerator.network;

import com.improve10x.usergenerator.Constants;
import com.improve10x.usergenerator.modelclass.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomPeopleService {

    @GET(Constants.RANDOM_END_POINT)
    Call<List<User>> fetchRandomPeoples();
}
