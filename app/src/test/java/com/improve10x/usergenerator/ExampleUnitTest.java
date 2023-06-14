package com.improve10x.usergenerator;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.usergenerator.model.Address;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.randomNetwork.RandomPeopleApi;
import com.improve10x.usergenerator.network.randomNetwork.RandomPeopleApiService;
import com.improve10x.usergenerator.network.usersNetwork.UsersApi;
import com.improve10x.usergenerator.network.usersNetwork.UsersApiService;

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
    public void getRandomPeople() throws IOException {
        RandomPeopleApiService randomPeopleApiService = new RandomPeopleApi().createRandomPeopleApiService();
        Call<List<User>> call = randomPeopleApiService.getRandomPeople();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public void getUsers() throws IOException {
        UsersApiService usersApiService = new UsersApi().createUserApiService();
        Call<List<User>> call = usersApiService.getUsers();
        List<User> users = call.execute().body();
        assertNotNull(users);
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public void addUser() throws IOException {
        UsersApiService usersApiService = new UsersApi().createUserApiService();
        Address address = new Address("basireddy bavi Street", "Kurnool", "Andhrapradesh", "India",
                "5161", 56789, "9526341521", "433.2", "IND");
        User user = new User("Sai", 20, "developer", 567, 57, "1234-3452",
                false, false, 156, 5.6f, "black", "sai@improve10x.com", "female", true, "B+",
                "sri", 0.02f, "Hindu", address, "1995", 1.0f);
        Call<User> call = usersApiService.createUser(user);
        User user1 = call.execute().body();
        assertNotNull(user1);
        System.out.println(new Gson().toJson(user1));
    }

    @Test
    public void deleteUser() throws IOException {
        UsersApiService usersApiService = new UsersApi().createUserApiService();
        Call<Void> call = usersApiService.deleteUser("6486fe56c632b703e8303ad5");
        call.execute();
    }
}