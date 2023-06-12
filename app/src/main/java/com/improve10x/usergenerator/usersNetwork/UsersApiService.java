package com.improve10x.usergenerator.usersNetwork;

import com.improve10x.usergenerator.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersApiService {

    @GET("venusTemplates")
    Call<List<Person>> getUsersDetails();
}
