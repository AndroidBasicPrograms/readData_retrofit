package com.example.jayhind.lecture_app.Retrofit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class apiClient {
    public static Retrofit r=null;
    public static Retrofit getclient(){
        if(r==null)
        {
        r=new Retrofit.Builder().baseUrl("http://192.168.43.55/android/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return r;
    };
}
