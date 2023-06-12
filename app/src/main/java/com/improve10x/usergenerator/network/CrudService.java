package com.improve10x.usergenerator.network;

import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CrudService {

    @GET("479dd07f8c1d482e9219f7dcb48e25f4/marsTemplates")
    Call<List<User>> fetchData();

    @POST("479dd07f8c1d482e9219f7dcb48e25f4/marsTemplates")
    Call<User> createData(@Body User user);

    @DELETE("479dd07f8c1d482e9219f7dcb48e25f4/marsTemplates/{id}")
    Call<Void> deleteData(@Path("id") String id);
}
