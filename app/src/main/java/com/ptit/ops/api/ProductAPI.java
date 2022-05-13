package com.ptit.ops.api;

import com.ptit.ops.response.ProductResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ProductAPI extends BaseAPI{

    ProductAPI api = new Retrofit.Builder()
            .baseUrl(URI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ProductAPI.class);

    @GET("/product")
    Call<ProductResponse> findAll();
}
