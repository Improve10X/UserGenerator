package com.improve10x.usergenerator.network;

import com.improve10x.usergenerator.modelclass.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CrudUsersService {

    @GET("marsTemplates")
    Call<List<User>> fetchCrudUsers();

    @POST("marsTemplates")
    Call<User> createCrudUser(@Body User user);

    @DELETE("marsTemplates/{id}")
    Call<Void> deleteCrudUser(@Path("id") String id);
}
