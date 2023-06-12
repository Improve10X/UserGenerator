package com.improve10x.usergenerator;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.usergenerator.model.Address;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.CrudApiService;
import com.improve10x.usergenerator.network.CrudApi;
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
    public void getUsers() throws IOException { // random
        PeopleGenerateApi peopleGenerateApi = new PeopleGenerateApi();
        PeopleGenerateApiService peopleGenerateApiService = peopleGenerateApi.createUserApiService();
        Call<List<User>> call = peopleGenerateApiService.fetchUsers();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public void createUser() throws IOException {
        CrudApi crudApi = new CrudApi();
        CrudApiService crudApiService = crudApi.createCurdApiService();
        Address address = new Address("Telugu Peta", "Velugode", "Andhra pradesh",
                "India", "zip", 1938, "9014523499", "bommal satram", "+91");
        User user = new User("surya", 23, "Android developer", 1929487,
                192934, "294jgghd", false,
                false, 160, 68.0f, "Black", "ssss.com",
                "male", true, "B+ve", "surya", 190.0f,
                "Hindhu", address, "1999-09-12",70.0f );
        Call<User> call = crudApiService.createUser(user);
        User users = call.execute().body();
        assertNotNull(users);
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public void fetchUsers() throws IOException {
        CrudApi crudApi = new CrudApi();
        CrudApiService crudApiService = crudApi.createCurdApiService();
        Call<List<User>> call = crudApiService.fetchUsers();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }
}