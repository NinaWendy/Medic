package com.dev.honeycomb_mobile.network.Interfaces;

import com.dev.honeycomb_mobile.models.DrugList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DrugApi {
    @GET("{slug}")
    Call<DrugList> getInfo(@Path("slug") String slug);
}
