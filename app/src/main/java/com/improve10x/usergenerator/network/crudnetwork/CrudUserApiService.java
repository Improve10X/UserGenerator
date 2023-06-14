package com.improve10x.usergenerator.network.crudnetwork;

import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CrudUserApiService {

    @POST("earthTemplates")
    Call<User> createUser(@Body User user);

    @GET("earthTemplates")
    Call<List<User>> fetchUsers();

    @DELETE("earthTemplates/{id}")
    Call<Void> deleteUser(@Path("id") String id);
}
