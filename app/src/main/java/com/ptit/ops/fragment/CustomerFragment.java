package com.ptit.ops.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ptit.ops.AddActivity;
import com.ptit.ops.R;
import com.ptit.ops.UpdateActivity;
import com.ptit.ops.adapter.RecycleViewCustomerAdapter;
import com.ptit.ops.api.CustomerAPI;
import com.ptit.ops.model.CustomerModel;
import com.ptit.ops.response.CustomerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerFragment extends Fragment implements RecycleViewCustomerAdapter.ItemListener {

    private RecycleViewCustomerAdapter adapter;
    private RecyclerView recyclerView;
    private Button buttonCreateCustomer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewCustomer);
        buttonCreateCustomer = view.findViewById(R.id.buttonCreateCustomer);
        adapter = new RecycleViewCustomerAdapter();
        adapter.reload();
        adapter.setItemListener(this);

        CustomerAPI.api.findAll().enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                CustomerResponse customerResponse = response.body();
                List<CustomerModel> modelList = customerResponse.getCustomers();
                adapter.setModelList(modelList);
                LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Call API error", Toast.LENGTH_SHORT).show();
            }
        });

        buttonCreateCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), UpdateActivity.class);
        CustomerModel model = adapter.getModelList().get(position);
        intent.putExtra("model", model);
        startActivity(intent);
    }
}
