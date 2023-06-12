package com.improve10x.usergenerator;

import com.improve10x.usergenerator.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApiService {

    @GET("api/person/10")
    Call<List<Person>> getUsersDetails();
}
