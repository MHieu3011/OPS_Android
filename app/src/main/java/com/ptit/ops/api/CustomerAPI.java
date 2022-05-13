package com.ptit.ops.api;

import com.ptit.ops.response.CustomerResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CustomerAPI extends BaseAPI {

    CustomerAPI api = new Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CustomerAPI.class);

    @GET("/customer")
    Call<CustomerResponse> findAll();

    @POST("/customer")
    Call<CustomerResponse> create(
            @Query("name") String name,
            @Query("address") String address,
            @Query("phone") String phone
    );
}
