package com.improve10x.usergenerator.network.cruduserapi;

import com.improve10x.usergenerator.Constants;
import com.improve10x.usergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CrudUsersService {
    @GET(Constants.CRUD_USER_END_POINT)
    Call<List<User>> fetchUsers();

    @POST(Constants.CRUD_USER_END_POINT)
    Call<User> createUser(@Body User user);

    @DELETE(Constants.CRUD_USER_END_POINT + "/{id}")
    Call<Void> deleteUser(@Path("id") String id);
}
