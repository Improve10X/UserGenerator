package com.improve10x.usergenerator.network.pepolegeneratornetwork;

import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeopleGeneratorApiService {

    @GET("person/10")
    Call<List<User>> fetchGeneratorUsers();
}
