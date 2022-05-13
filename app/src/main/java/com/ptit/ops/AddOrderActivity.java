package com.ptit.ops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ptit.ops.api.OrderAPI;
import com.ptit.ops.response.OrderResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddOrderActivity extends AppCompatActivity {

    private EditText editTextIdCustomer;
    private EditText editTextIdProduct;
    private EditText editTextAmount;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        editTextIdCustomer = findViewById(R.id.editTextIDCustomer);
        editTextIdProduct = findViewById(R.id.editTextIDProduct);
        editTextAmount = findViewById(R.id.editTextAmount);
        button = findViewById(R.id.buttonCreateOrder);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idCustomer = Integer.parseInt(editTextIdCustomer.getText().toString());
                int idProduct = Integer.parseInt(editTextIdProduct.getText().toString());
                int amount = Integer.parseInt(editTextAmount.getText().toString());
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String orderDate = sdf.format(date);

                OrderAPI.api.create(idCustomer, idProduct, amount, orderDate).enqueue(new Callback<OrderResponse>() {
                    @Override
                    public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<OrderResponse> call, Throwable t) {

                    }
                });
                Toast.makeText(getApplication(), "Success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}