package com.ptit.ops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ptit.ops.api.CustomerAPI;
import com.ptit.ops.response.CustomerResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAddress;
    private EditText editTextPhone;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        editTextName = findViewById(R.id.editTextNameCreateCustomer);
        editTextAddress = findViewById(R.id.editTextAddressCreateCustomer);
        editTextPhone = findViewById(R.id.editTextPhoneCreateCustomer);
        button = findViewById(R.id.buttonCreate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                String phone = editTextPhone.getText().toString();

                CustomerAPI.api.create(name, address, phone).enqueue(new Callback<CustomerResponse>() {
                    @Override
                    public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<CustomerResponse> call, Throwable t) {

                    }
                });
                Toast.makeText(getApplication(), "Success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}