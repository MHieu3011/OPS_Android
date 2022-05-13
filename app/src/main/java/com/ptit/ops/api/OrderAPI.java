package com.ptit.ops.api;

import com.ptit.ops.response.OrderResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OrderAPI extends BaseAPI {

    OrderAPI api = new Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(OrderAPI.class);

    @GET("/order")
    Call<OrderResponse> findAll();

    @GET("/order/id")
    Call<OrderResponse> findByCustomerId(
            @Query("customer_id") int customerId
    );

    @POST("/order")
    Call<OrderResponse> create(
            @Query("customer_id") int customerId,
            @Query("product_id") int productId,
            @Query("amount") int amount,
            @Query("order_date") String orderDate
    );
}
