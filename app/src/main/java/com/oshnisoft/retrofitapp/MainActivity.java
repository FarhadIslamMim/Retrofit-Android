package com.oshnisoft.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
Call<OurMainDataClass> call;
List<ObjectData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit
                              .Builder()
                              .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                              .addConverterFactory(GsonConverterFactory.create())
                              .build();

          OurRetrofitClient ourRetrofitClient=retrofit.create(OurRetrofitClient.class);
        call=ourRetrofitClient.getData("LRRfTKsirytpYA3nwgL96GymKKdFbzSQFCEhLnZraS8np0NVVQHoAHAbhfSx");
   call.enqueue(new Callback<OurMainDataClass>() {
       @Override
       public void onResponse(Call<OurMainDataClass> call, Response<OurMainDataClass> response) {

           if(response.isSuccessful()){
           list=response.body().getData();
           for(ObjectData objectData:list ){
               Log.d("id", String.valueOf(objectData.getId()));
               Log.d("name", String.valueOf(objectData.getName()));
               Log.d("resource", String.valueOf(objectData.getResource()));
               Log.d("updated_at", String.valueOf(objectData.getUpdated_at()));
           }
           } else {
               Log.d("response","fail");
           }
       }

       @Override
       public void onFailure(Call<OurMainDataClass> call, Throwable t) {

           Log.d("response","fail");
       }
   });
    }
}