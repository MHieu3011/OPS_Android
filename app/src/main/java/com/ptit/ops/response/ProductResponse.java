package com.ptit.ops.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ptit.ops.model.ProductModel;

import java.util.List;

public class ProductResponse extends BaseResponse {

    @Expose
    @SerializedName("data")
    private List<ProductModel> products;

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
