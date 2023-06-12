package com.improve10x.usergenerator;

import org.junit.Test;

import static org.junit.Assert.*;


import com.google.gson.Gson;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.PeopleGenerateApi;
import com.improve10x.usergenerator.network.PeopleGenerateApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getUsers() throws IOException {
        PeopleGenerateApi peopleGenerateApi = new PeopleGenerateApi();
        PeopleGenerateApiService peopleGenerateApiService = peopleGenerateApi.createUserApiService();
        Call<List<User>> call = peopleGenerateApiService.fetchUsers();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }
}