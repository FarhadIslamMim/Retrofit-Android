package com.oshnisoft.retrofitapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OurRetrofitClient {

//    @GET("continents")
//    Call<OurMainDataClass> getData(@Query("api_token") String token);

    //for get data by id
    @GET("continents/{id}")
    Call<ObjectDataById> getData(@Path("id") int id, @Query("api_token") String token);


}

