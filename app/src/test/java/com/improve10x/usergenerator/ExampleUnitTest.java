package com.improve10x.usergenerator;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.usergenerator.model.Address;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.CrudApi;
import com.improve10x.usergenerator.network.CrudService;
import com.improve10x.usergenerator.network.PeopleApi;
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
    public void getPeopleData() throws IOException {
        RandomPeopleService randomPeopleService = new PeopleApi().createRandomPeopleService();
        Call<List<User>> call = randomPeopleService.fetchRandomPeople();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public void getCrudApiData() throws IOException {
        CrudService crudService = new CrudApi().createCrudService();
        Call<List<User>> call = crudService.fetchData();
        List<User> users = call.execute().body();
        assertNotNull(users);
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public void createCrudApiData() throws IOException {
        CrudService crudService = new CrudApi().createCrudService();
        Address address = new Address("Ngo's colony", "nandyal", "Ap",
                "India", "zip", 518533,
                "9052363630", "786i", "Ind");
        User user = new User("charan teja", 23, "developer", 4646,
                45, "5279 1500 5285", false,
                false, 156, 60.00f, "Black", "zingzing@gmail.com",
                "male", true, "A+", "teja",
                0.00f, "hindu", address, "2001", 9.99f);
        Call<User> call = crudService.createData(user);
        User user1 = call.execute().body();
        assertNotNull(user1);
        System.out.println(new Gson().toJson(user1));
    }
}