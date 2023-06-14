package com.improve10x.usergenerator;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.usergenerator.modelclass.Address;
import com.improve10x.usergenerator.modelclass.User;
import com.improve10x.usergenerator.network.CrudUsersApi;
import com.improve10x.usergenerator.network.CrudUsersService;
import com.improve10x.usergenerator.network.RandomPeopleApi;
import com.improve10x.usergenerator.network.RandomPeopleService;

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
        RandomPeopleService randomPeopleService = new RandomPeopleApi().createRandomPeopleService();
        Call<List<User>> call = randomPeopleService.fetchRandomPeople();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public void getCrudUsers() throws IOException {
        CrudUsersService crudUsersService = new CrudUsersApi().createCrudUsersService();
        Call<List<User>> call = crudUsersService.fetchCrudUsers();
        List<User> userList = call.execute().body();
        assertNotNull(userList);
        System.out.println(new Gson().toJson(userList));
    }

    @Test
    public void createCrudUser() throws IOException {
        CrudUsersService crudUsersService = new CrudUsersApi().createCrudUsersService();
        Address address = new Address("VandanpuriColony","Hyderabad","TS","India","502032",5000, "9885592629","Near vijetha superMarket","50890");
        User user = new User("Anupama",35, "Developer", 80, 50, "678", true, true, 156, 69.5f, "black", "anupama_5529@yahoo.co.in", "Female", true, "B+ve","anu", 6.5f, "Hindu", address, "4th November", 8.5f);
        Call<User> call = crudUsersService.createCrudUser(user);
        User responseUser = call.execute().body();
        assertNotNull(responseUser);
        System.out.println(new Gson().toJson(responseUser));
    }
}