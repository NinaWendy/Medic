package com.dev.honeycomb_mobile.network.clients;

import com.dev.honeycomb_mobile.models.Constants;
import com.dev.honeycomb_mobile.network.interfaces.DoctorApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DoctorClient {
    private static Retrofit retrofit = null;

    public static DoctorApi getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.DOCTOR_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // handles data serialization from JSON to Java objects
                    .build();
        }

        return retrofit.create(DoctorApi.class);
    }
}
