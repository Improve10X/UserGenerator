package com.improve10x.usergenerator;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.usergenerator.model.Address;
import com.improve10x.usergenerator.model.User;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApiService;
import com.improve10x.usergenerator.network.crudnetwork.CrudUserApi;
import com.improve10x.usergenerator.network.pepolegeneratornetwork.PeopleGeneratorApi;
import com.improve10x.usergenerator.network.pepolegeneratornetwork.PeopleGeneratorApiService;

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
    public void getPeopleGenerateUsers() throws IOException {
        PeopleGeneratorApi peopleGeneratorApi = new PeopleGeneratorApi();
        PeopleGeneratorApiService peopleGeneratorApiService = peopleGeneratorApi.createPeopleGeneratorApiService();
        Call<List<User>> call = peopleGeneratorApiService.fetchGeneratorUsers();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public void createUser() throws IOException {
        CrudUserApi crudUserApi = new CrudUserApi();
        CrudUserApiService crudUserApiService = crudUserApi.createCrudUserApiService();
        Address address = new Address("Telugu Peta", "Velugode", "Andhra pradesh",
                "India", "zip", 1938, "9014523499", "bommal satram", "+91");
        User user = new User("surya", 23, "Android developer", 1929487,
                192934, "294jgghd", false,
                false, 160, 68.0f, "Black", "ssss.com",
                "male", true, "B+ve", "surya", 190.0f,
                "Hindhu", address, "1999-09-12",70.0f );
        Call<User> call = crudUserApiService.createUser(user);
        User user1 = call.execute().body();
        assertNotNull(user1);
        System.out.println(new Gson().toJson(user1));
    }

    @Test
    public void getUsers() throws IOException {
        CrudUserApi crudUserApi = new CrudUserApi();
        CrudUserApiService crudUserApiService = crudUserApi.createCrudUserApiService();
        Call<List<User>> call = crudUserApiService.fetchUsers();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public void deleteUser() throws IOException {
        CrudUserApi crudUserApi = new CrudUserApi();
        CrudUserApiService crudUserApiService = crudUserApi.createCrudUserApiService();
        Call<Void> call = crudUserApiService.deleteUser("64870936c632b703e8303b25");
        call.execute();
    }
}