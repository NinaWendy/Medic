package com.dev.honeycomb_mobile.network.interfaces;

import com.dev.honeycomb_mobile.models.Doctor;
import com.dev.honeycomb_mobile.models.DoctorDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DoctorApi {
    @GET("/doctor")
    Call<List<Doctor>> getResults(
            //name it as it is in the API documentation
    );
}
