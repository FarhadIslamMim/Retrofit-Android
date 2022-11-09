package com.oshnisoft.retrofitapp;

import com.oshnisoft.retrofitapp.cricket.ArrayModelClass;
import com.oshnisoft.retrofitapp.cricket.TeamClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OurRetrofitClient {

//    @GET("continents")
//    Call<OurMainDataClass> getData(@Query("api_token") String token);

    //for get data by id
   // @GET("continents/{id}")
    //Call<ObjectDataById> getData(@Path("id") int id, @Query("api_token") String token);

    //team
    @GET("teams/{id}")
    Call<TeamClass> getData(@Path("id") int id, @Query("api_token") String token);

    //players
    @GET("players")
    Call<ArrayModelClass> getPlayersData(@Query("api_token") String token, @Query("country_id")  int cid);


}

