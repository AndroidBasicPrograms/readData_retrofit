package com.example.jayhind.lecture_app.Retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by User on 01-05-2018.
 */
public interface apiService{
    @FormUrlEncoded
    @POST("client.php")
    Call<String> insertClient(@Field("name") String name, @Field("age") int age);

    @GET("user.php")
    Call<userResponse> getAllUser();
    //@Query("select") String select
}
