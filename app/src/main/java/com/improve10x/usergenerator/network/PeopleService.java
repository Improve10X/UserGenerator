package com.improve10x.usergenerator.network;

import com.improve10x.usergenerator.Constants;
import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface PeopleService {
    @GET(Constants.PEOPLE_END_POINT)
    Call<List<User>> fetchPeopleGenerator();
}
