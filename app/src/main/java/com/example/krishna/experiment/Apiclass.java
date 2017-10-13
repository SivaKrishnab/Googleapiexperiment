package com.example.krishna.experiment;

import com.example.krishna.experiment.Pojo.example;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Krishna on 10/13/2017.
 */

public interface Apiclass {
    @GET("maps/api/directions/json?origin=39.004554,-76.875528&destination=39.290385,-76.612189")
    Call<example> getJso();
}
