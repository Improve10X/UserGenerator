package com.improve10x.usergenerator.network;

import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CrudApiService {

    @POST("479dd07f8c1d482e9219f7dcb48e25f4/earthTemplates")
    Call<User> createUser(@Body User user);

    @GET("479dd07f8c1d482e9219f7dcb48e25f4/earthTemplates")
    Call<List<User>> fetchUsers();
}
