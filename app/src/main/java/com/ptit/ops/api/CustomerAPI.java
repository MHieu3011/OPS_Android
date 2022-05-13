package com.ptit.ops.api;

import com.ptit.ops.response.CustomerResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface CustomerAPI extends BaseAPI{

    CustomerAPI api = new Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CustomerAPI.class);

    @GET("/customer")
    Call<CustomerResponse> findAll();
}
