package com.example.lindoro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {

    @GET("users")
    Call<List<User>> findUsersByEmail(@Query("email") String email);

}
