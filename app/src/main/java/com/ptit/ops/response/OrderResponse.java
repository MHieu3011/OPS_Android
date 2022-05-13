package com.ptit.ops.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ptit.ops.model.OrderModel;

import java.util.List;

public class OrderResponse extends BaseResponse {

    @Expose
    @SerializedName("data")
    private List<OrderModel> orders;

    public List<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }
}
