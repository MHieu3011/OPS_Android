package com.ptit.ops.api;

import com.ptit.ops.response.OrderResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface OrderAPI extends BaseAPI {

    OrderAPI api = new Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(OrderAPI.class);

    @GET("/order")
    Call<OrderResponse> findAll();
}
