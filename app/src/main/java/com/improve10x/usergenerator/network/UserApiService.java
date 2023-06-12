package com.improve10x.usergenerator.network;

import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApiService {

    @GET("person/10")
    Call<List<User>> fetchUsers();
}
