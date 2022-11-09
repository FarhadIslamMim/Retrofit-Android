package com.oshnisoft.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.oshnisoft.retrofitapp.cricket.ArrayModelClass;
import com.oshnisoft.retrofitapp.cricket.ObjectModelClass;
import com.oshnisoft.retrofitapp.cricket.PositionClass;
import com.oshnisoft.retrofitapp.cricket.TeamClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
Call<OurMainDataClass> call;

OurRetrofitClient ourRetrofitClient;
Call<ObjectDataById> callId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit
                              .Builder()
                              .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                              .addConverterFactory(GsonConverterFactory.create())
                              .build();

          ourRetrofitClient=retrofit.create(OurRetrofitClient.class);
        Call<TeamClass> callTeam=ourRetrofitClient.getData(10,"LRRfTKsirytpYA3nwgL96GymKKdFbzSQFCEhLnZraS8np0NVVQHoAHAbhfSx");

        callTeam.enqueue(new Callback<TeamClass>() {
            @Override
            public void onResponse(Call<TeamClass> call, Response<TeamClass> response) {

              final   int cid=response.body().getCountry_id();
                String name=response.body().getName();

                Call<ArrayModelClass> playerCall=ourRetrofitClient.getPlayersData("LRRfTKsirytpYA3nwgL96GymKKdFbzSQFCEhLnZraS8np0NVVQHoAHAbhfSx",cid);

                playerCall.enqueue(new Callback<ArrayModelClass>() {
                    @Override
                    public void onResponse(Call<ArrayModelClass> call, Response<ArrayModelClass> response) {
                        List<ObjectModelClass> list=response.body().getData();
                        for (ObjectModelClass obj: list){
                            String dob=obj.getDeteofbirth();
                            String fullname=obj.getFullname();
                            String gender=obj.getGender();

                            PositionClass position=obj.getPosition();

                            String posname=position.getName();

                            Log.d("cid :",String.valueOf(cid));
                            Log.d("dob :",String.valueOf(dob));
                            Log.d("fullname :",String.valueOf(fullname));
                            Log.d("gender :",String.valueOf(gender));
                            Log.d("posname :",String.valueOf(posname));
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayModelClass> call, Throwable t) {

                    }
                });

            }

            @Override
            public void onFailure(Call<TeamClass> call, Throwable t) {

            }
        });


//        callId.enqueue(new Callback<ObjectDataById>() {
//            @Override
//            public void onResponse(Call<ObjectDataById> call, Response<ObjectDataById> response) {
//
//                if(response.isSuccessful()){
//                    ObjectData objectData=response.body().getData();
//
//                        Log.d("id", String.valueOf(objectData.getId()));
//                        Log.d("name", String.valueOf(objectData.getName()));
//                        Log.d("resource", String.valueOf(objectData.getResource()));
//                        Log.d("updated_at", String.valueOf(objectData.getUpdated_at()));
//
//                } else {
//                    Log.d("response","fail");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ObjectDataById> call, Throwable t) {
//
//                Log.d("response","fail");
//            }
//        });


//        call.enqueue(new Callback<OurMainDataClass>() {
//       @Override
//       public void onResponse(Call<OurMainDataClass> call, Response<OurMainDataClass> response) {
//
//           if(response.isSuccessful()){
//           list=response.body().getData();
//           for(ObjectData objectData:list ){
//               Log.d("id", String.valueOf(objectData.getId()));
//               Log.d("name", String.valueOf(objectData.getName()));
//               Log.d("resource", String.valueOf(objectData.getResource()));
//               Log.d("updated_at", String.valueOf(objectData.getUpdated_at()));
//           }
//           } else {
//               Log.d("response","fail");
//           }
//       }
//
//       @Override
//       public void onFailure(Call<OurMainDataClass> call, Throwable t) {
//
//           Log.d("response","fail");
//       }
//   });
    }
}