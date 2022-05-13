package com.ptit.ops;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ptit.ops.api.CustomerAPI;
import com.ptit.ops.model.CustomerModel;
import com.ptit.ops.response.CustomerResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAddress;
    private EditText editTextPhone;
    private Button buttonUpdate;
    private Button buttonCancel;
    private CustomerModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        editTextName = findViewById(R.id.editTextNameUpdateCustomer);
        editTextAddress = findViewById(R.id.editTextAddressUpdateCustomer);
        editTextPhone = findViewById(R.id.editTextPhoneUpdateCustomer);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonCancel = findViewById(R.id.buttonCancel);

        Intent intent = getIntent();
        model = (CustomerModel) intent.getSerializableExtra("model");
        editTextName.setText(model.getName());
        editTextAddress.setText(model.getAddress());
        editTextPhone.setText(model.getPhone());

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = model.getId();
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                String phone = editTextPhone.getText().toString();
                CustomerAPI.api.update(id, name, address, phone).enqueue(new Callback<CustomerResponse>() {
                    @Override
                    public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<CustomerResponse> call, Throwable t) {

                    }
                });
                Toast.makeText(UpdateActivity.this, "Success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}