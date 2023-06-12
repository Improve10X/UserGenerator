package com.improve10x.usergenerator;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.usergenerator.model.Person;
import com.improve10x.usergenerator.randomNetwork.RandomPersonApi;
import com.improve10x.usergenerator.randomNetwork.RandomPersonApiService;
import com.improve10x.usergenerator.usersNetwork.UsersApi;
import com.improve10x.usergenerator.usersNetwork.UsersApiService;

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
    public void getRandomPersonsDetails() throws IOException {
        RandomPersonApiService randomPersonApiService = new RandomPersonApi().createUserApiService();
        Call<List<Person>> call = randomPersonApiService.getRandomPersonDetails();
        List<Person> person = call.execute().body();
        assertNotNull(person);
        assertFalse(person.isEmpty());
        System.out.println(new Gson().toJson(person));
    }

    @Test
    public void getUserDetails() throws IOException {
        UsersApiService usersApiService = new UsersApi().createUserApiService();
        Call<List<Person>> call = usersApiService.getUsersDetails();
        List<Person> person = call.execute().body();
        assertNotNull(person);
        System.out.println(new Gson().toJson(person));
    }
}