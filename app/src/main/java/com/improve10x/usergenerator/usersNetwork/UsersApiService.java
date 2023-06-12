package com.improve10x.usergenerator.usersNetwork;

import com.improve10x.usergenerator.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsersApiService {

    @GET("venusTemplates")
    Call<List<Person>> getUsersDetails();

    @POST("venusTemplates")
    Call<Person> createPersonDetails(@Body Person person);

    @DELETE("venusTemplates/{id}")
    Call<Void> deletePersonDetails(@Path("id") String id);
}
