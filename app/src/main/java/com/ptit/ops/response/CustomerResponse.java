package com.ptit.ops.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ptit.ops.model.CustomerModel;

import java.util.List;

public class CustomerResponse extends BaseResponse {

    @Expose
    @SerializedName("data")
    private List<CustomerModel> customers;

    public List<CustomerModel> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerModel> customers) {
        this.customers = customers;
    }
}
