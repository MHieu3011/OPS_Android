package com.ptit.ops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ptit.ops.api.CustomerAPI;
import com.ptit.ops.model.CustomerModel;
import com.ptit.ops.response.CustomerResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        CustomerAPI.api.findAll().enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                CustomerResponse customerResponse = response.body();
                List<CustomerModel> customers = customerResponse.getCustomers();
                textView.setText(customers.size()+"");
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {

            }
        });

    }
}