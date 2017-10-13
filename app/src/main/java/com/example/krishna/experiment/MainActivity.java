package com.example.krishna.experiment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.krishna.experiment.Pojo.GeocodedWaypoint;
import com.example.krishna.experiment.Pojo.Route;
import com.example.krishna.experiment.Pojo.example;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
ArrayList<Route> geocodedWaypoints;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text);
        retrofit2.Retrofit retrofit=new retrofit2.Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiclass service=retrofit.create(Apiclass.class);
        Call<example> call=service.getJso();
        call.enqueue(new Callback<example>() {
            @Override
            public void onResponse(Call<example> call, Response<example> response) {
                example json=response.body();
                geocodedWaypoints=new ArrayList<Route>(json.getRoutes());
                Log.d("ss",String.valueOf(geocodedWaypoints.get(0).getLegs().get(0).getDistance().getText()));
                textView.setText(geocodedWaypoints.get(0).getLegs().get(0).getDistance().getText());
            }

            @Override
            public void onFailure(Call<example> call, Throwable t) {

            }
        });
    }
}
